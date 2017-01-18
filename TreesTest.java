import javax.swing.JFrame;

/** This is a demonstration class for the class Trees.
 * @author Dhanish Ashraf
 *
 */
public class TreesTest { 

	public static void main(String[] args) {
		
		//Expect 5 trees in size order (smallest to biggest) in a diagonal line.
		
		int[] xTrees = {10, 20, 50, 70, 160};
		  int[] yTrees = {10, 20, 50, 70, 160};
		  int[] scale = {2, 4, 6, 15, 25};
		  Trees panel =  new Trees(xTrees, yTrees, scale);
	        JFrame frame = new JFrame();
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        final int FRAME_WIDTH = 800;
	        final int FRAME_HEIGHT = 800;
	        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT); 
	        //creates a window of size 600 x 600 pixels
	        frame.add(panel); 
	        frame.setVisible(true); // makes the application visible.

	}

}
