import javax.swing.JFrame;

/** This is a demonstration class for the class HtmlReadGuiInner.
 * @author Dhanish Ashraf
 *
 */
public class HtmlReadGuiInnerTest {

	public static void main(String[] args) {
		
		//Expect 3 rows and 1 column with "Please enter URL" & "Please enter filename" text fields and a "DOWNLOAD" button
		//When we click download, if the URL exists, a message should appear that says "Download Successful"
			// otherwise a "Download failed" error message should appear.
		
		HtmlReadGuiInner htmlReader = new HtmlReadGuiInner();
		htmlReader.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		htmlReader.setSize(200, 300);
		htmlReader.setVisible(true);	

	}

}
