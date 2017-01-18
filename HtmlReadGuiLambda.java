import java.awt.Font;
import java.awt.GridLayout;
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
 * This class makes use of Lambda functions.
 * @author Dhanish Ashraf
 */
public class HtmlReadGuiLambda extends JFrame { 
	
	private final JButton button1; //The download button
	private final JTextField field1; //The URL field
	private final JTextField field2; //The filename field
	
	/** Adjusting the layout
	 *  Creating and adding the buttons
	 *  Registering the event handler
	 */
	public HtmlReadGuiLambda(){
		
		super("Read HTML file"); //the name of the window
		
		//Setting the layout
		GridLayout layout = new GridLayout(3,1);
		setLayout(layout);
		
		//Initialising the two fields and a button
		field1 = new JTextField("Please enter URL");
		field2 = new JTextField("Please enter filename");
		button1 = new JButton("DOWNLOAD");	
		button1.setFont(new Font("Arial", Font.BOLD, 14));
		
		//Adding the fields and buttons
		add(field1);
		add(field2);
		add(button1);
		
		//Here we define the lambda function as an event when we add the ActionListener
		//The lambda function is buffered readers and writers which downloads the given URL to the specified file.
		button1.addActionListener(event -> { String readString;
        try {
            URL url = new URL(field1.getText());
            BufferedReader in =
                new BufferedReader(new
                                   InputStreamReader(url.openStream()));
            BufferedWriter out =
                new BufferedWriter(new FileWriter(field2.getText()));
           
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
		});
	
	}

}
