import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/** A GUI that allows a user to download an HTML file of their 
 * choice to a local file of their choice.
 * This class makes use of an inner class.
 * @author Dhanish Ashraf
 */
public class HtmlReadGuiInner extends JFrame {
	
	private final JButton button1; //The download button
	private final JTextField field1; //The URL field
	private final JTextField field2; //The filename field
	
	/** Adjusting the layout
	 *  Creating and adding the buttons
	 *  Registering the event handler
	 */ 
	public HtmlReadGuiInner(){ 
		
		super("Read HTML file"); //the name of the window
		
		//Setting the layout
		GridLayout layout = new GridLayout(3,1); //3 rows by 1 column
		setLayout(layout);
		
		//Initialising the two fields and a button
		field1 = new JTextField("Please enter URL");
		field2 = new JTextField("Please enter filename");
		button1 = new JButton("DOWNLOAD");	
		button1.setFont(new Font("Arial", Font.BOLD, 14)); //Editing the font of the text of the DOWNLOAD button
		
		//Adding the fields and buttons
		add(field1);
		add(field2);
		add(button1);
		
		//register event handlers
		DownloadHandler handler = new DownloadHandler();	
		button1.addActionListener(handler);
	}
	
	//Private inner class for event handling
	/** An inner class that implements ActionListner.
	 * Specifies what should happen when the DOWNLOAD button is clicked.
	 * @author Dhanish Ashraf
	 *
	 */
	private class DownloadHandler implements ActionListener{
		
		@Override 
		public void actionPerformed(ActionEvent event){ //Here we define what actions should be made when the DOWNLOAD button is clicked.
			
			String s = field1.getText(); //getting the user inputed text (URL) from field1 as a String
			String filename = field2.getText(); //getting the user inputed text (filename) from field2 as a String
			
			//Defining how to download the URL through Buffered Readers and Writers
			 String readString;
		        try {
		            URL url = new URL(s);
		            BufferedReader in =
		                new BufferedReader(new
		                                   InputStreamReader(url.openStream()));
		            BufferedWriter out =
		                new BufferedWriter(new FileWriter(filename));
		           
		            while ((readString = in.readLine()) != null) {		                
		                out.write(readString + "\n");
		            }

		            in.close();
		            out.close();
		            //A message to notify the user that the url was successfully downloaded.
		            JOptionPane.showMessageDialog(null, "Download Successful.");
		        }
		        //If an exception is thrown, show the user an error message.
		        catch (IOException e) {
		            JOptionPane.showMessageDialog(null, "Download failed.", "Error", JOptionPane.ERROR_MESSAGE);
		        }
			
		}
		
	}
	
	
}
