import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JFrame;

/** A class that makes use of graphics to make a christmas tree.
 * @author Dhanish Ashraf
 *
 */
public class Trees extends JPanel {

	protected int[] xTrees; //x-coordinates of the 'imaginary boxes' 
	protected int[] yTrees; //y-coordinates of the 'imaginary boxes'
	protected int[] scaleTrees; //scale of the trees
	
	/** The constructor
	 * @param xTrees array of x-coordinates for the trees
	 * @param yTrees array of y-coordinates for the trees
	 * @param scaleTrees array of scales of the trees
	 */
	public Trees(int[] xTrees, int[] yTrees, int[] scaleTrees){
		this.xTrees = xTrees;
		this.yTrees = yTrees;
		this.scaleTrees = scaleTrees;
	}
	
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		
		for(int i = 0; i < xTrees.length; i++){
			
			int xTempOffset = xTrees[i] + 5*scaleTrees[i];  //temporary x-coordinate of upper left corner of trunk
			int yTempOffset = yTrees[i] + 12*scaleTrees[i]; //temporary y-coordinate of upper left corner of trunk
			
			//temporary arrays containing the x and y coordinates of the triangle that makes up the rest of the tree.
			int[] xTempTri = {xTrees[i] + 6*scaleTrees[i], xTrees[i] + 12*scaleTrees[i], xTrees[i]};
			int[] yTempTri = {yTrees[i], yTrees[i] + 12*scaleTrees[i], yTrees[i] + 12*scaleTrees[i]};
			
			//making the trunk
			Color Brown = new Color (139,69,19);  //creating colour brown
			g.setColor(Brown);	
			g.fillRect(xTempOffset, yTempOffset, 2*scaleTrees[i], 4*scaleTrees[i]);	
			
			//making the rest of the tree
			g.setColor(Color.GREEN);
			g.fillPolygon(xTempTri, yTempTri, 3);
		
		}
		
	  }

}
