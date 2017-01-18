import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/** This class implements ActionListener and is the listener for HTMLReadGuiSeparate class.
 * @author Dhanish Ashraf
 *
 */
public class DownloadHandler implements ActionListener {
	
	private final JTextField s; //The URL passed in from HTMLReadGuiSeparate class as a JTextField
	private final JTextField filename; //The filename passed in from HTMLReadGuiSeparate class as a JTextField
	
	/** The constructor
	 * @param field1 the URL as a JTextField 
	 * @param field2 the filename as a JTextField
	 */
	public DownloadHandler(JTextField field1, JTextField field2) { 
		this.s = field1;
		this.filename = field2;
	}

	
	public void actionPerformed(ActionEvent event){
		//Defining how to download the URL through Buffered Readers and Writers
		 String readString;
	        try {
	            URL url = new URL(s.getText());
	            BufferedReader in =
	                new BufferedReader(new
	                                   InputStreamReader(url.openStream()));
	            BufferedWriter out =
	                new BufferedWriter(new FileWriter(filename.getText()));
	           
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
