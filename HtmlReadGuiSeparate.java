import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/** A GUI that allows a user to download an HTML file of their 
 * choice to a local file of their choice.
 * This class has its ActionListener as a separate file (called DownloadHandler).
 * @author Dhanish Ashraf
 */
public class HtmlReadGuiSeparate extends JFrame {
	
	private final JButton button1;
	private final JTextField field1;
	private final JTextField field2;
	
	/** Adjusting the layout
	 *  Creating and adding the buttons
	 *  Registering the event handler
	 */
	public HtmlReadGuiSeparate(){
		
		super("Read HTML file"); //the name of the window
		
		//Setting the layout
		GridLayout layout = new GridLayout(3,1);
		setLayout(layout);
		
		//Initialising the two fields and a button
		field1 = new JTextField("Please enter URL");
		field2 = new JTextField("Please enter filename");
		button1 = new JButton("DOWNLOAD");	
		button1.setFont(new Font("Arial", Font.BOLD, 14));
		
		//Adding the fields and button
		add(field1);
		add(field2);
		add(button1);
		
		DownloadHandler handler = new DownloadHandler(field1, field2); //passing field1 and field2 to the DownloadHandler class.
		button1.addActionListener(handler);
		
}

public static void main(String[] args){
	
	HtmlReadGuiSeparate htmlReader = new HtmlReadGuiSeparate();
	htmlReader.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	htmlReader.setSize(300, 200);
	htmlReader.setVisible(true);
}
	
	
}
