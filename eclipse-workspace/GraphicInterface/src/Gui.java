import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui extends Thread{
	
	
	public Gui() {
		
		JFrame frame = new JFrame("Interface");
		
		frame.setSize(350,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		frame.add(panel);
		
		placeComponents(panel);
		
		frame.setVisible(true);
		
	}
	
	private static void placeComponents(JPanel panel) {
		
		panel.setLayout(null);
		
		JLabel userLabel = new JLabel("User");
		
		userLabel.setBounds(10,20,80,25);
		panel.add(userLabel);
		
		
		JLabel passwordLabel = new JLabel("Password");
		
		
		
		
		
	}

}
