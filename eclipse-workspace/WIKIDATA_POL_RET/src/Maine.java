

import java.util.ArrayList;
import java.util.HashMap;



public class Maine {

    public static void main(String[] args) {
        try {
            Endpoint sp = new Endpoint("https://query.wikidata.org/sparql", false);

            String querySelect = " SELECT ?name ?label\n" +
                "    WHERE{\n" +
                "       ?name wdt:P106 wd:Q82955.\n" +
                "       ?name wdt:P27 wd:Q155.\n" +
                "       ?name wdt:P937 wd:Q2844.\n" +
                "       ?name rdfs:label ?nameLabel.\n" +
                "       optional {?name wdt:P570 ?death}. \n" +
                "       filter (!bound(?death)).\n" +
                "       FILTER langMatches( lang(?nameLabel), \"pt\" ).\n" +
                "       BIND (STR(?nameLabel)  AS ?label)\n" +
                "    }\n" +
                "";

            HashMap rs = sp.query(querySelect);
            printResult(rs,30);

        }catch(EndpointException eex) {
            System.out.println(eex);
            eex.printStackTrace();
        }
    }

    public static void printResult(HashMap rs , int size) {

      for (String variable : (ArrayList) rs.get("result").get("variables")) {
        System.out.print(String.format("%-"+size+"."+size+"s", variable ) + " | ");
      }
      System.out.print("\n");
      for (HashMap value : (ArrayList>) rs.get("result").get("rows")) {
        //System.out.print(value);
        /* for (String key : value.keySet()) {
         System.out.println(value.get(key));
         }*/
        for (String variable : (ArrayList) rs.get("result").get("variables")) {
          //System.out.println(value.get(variable));
          System.out.print(String.format("%-"+size+"."+size+"s", value.get(variable)) + " | ");
        }
        System.out.print("\n");
      }
    }
}
