package Draw;

import java.awt.*;
import javax.swing.JPanel;
import java.awt.geom.*;
import java.awt.Polygon;

/**
 * Class used to create a DrawPanel where shapes will be drawn by the programer (via code).
 * 
 * @author Jared N. Plumb
 * @version 1.0
 * @since 2019-11-26
 * @Minor modifications by Jeff Light
 * @since 2019-12-01
 */
public class DrawPanel extends JPanel {
	//Attributes
	private static final long serialVersionUID = 6311020027600344213L;

	public DrawPanel() {
		this.setPreferredSize(new Dimension(1600, 900));	//Sets the dimensions of the DrawPanel.  Change this if your screen doesn't support this size.
		this.setOpaque(true);
		this.setBackground(Color.WHITE);					//Sets the background of the DrawPanel WHITE.  You may change this if desired.
	}
	/**
	 * Overrides the JComponent.paintComponent method.
	 * EVERYTHING that gets drawn to the Component (which sits on the content frame of the JFrame) is drawn in this method.
	 * Draw all your objectsDraw here.
	 * Automatically called by the event handler whenever the screen needs to be redrawn.
	 * DO NOT CALL THIS METHOD MANUALLY
	 * 
	 * @param	g	//All drawing in Java must go through a Graphics object
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;			//Allows us to draw using both the Graphics class methods and the Graphics2D class methods

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);	//Makes drawn shapes and fonts clearer

		
		/*
		 * Use this section to write your code.
		 * Draw at least 6 shapes in BOTH draw and fill formats using methods found in the Graphics class and/or the Graphics2D class.
		 * In other words, if you draw an empty rectangle, you should also draw a filled rectangle.  That counts as one (1) shape.
		 * The empty and filled versions of the shape should be at different orientations.
		 * One of the shapes MUST be a triangle.
		 * Each shape should be a different color.  An empty and a filled rectangle may be the same color, but they must be a different color from an empty and filled triangle.
		 * At least one of the colors should NOT be a standard color from the COLOR palette.
		 * Each empty shape should have a different stroke size.
		 * Be sure all shapes are located such that they can all be seen.
		 */

		// Added for Lab 6b: Draw Shapes

		// 1. Rectangle
		g2.setColor(Color.RED); // Standard color: Red
		g2.setStroke(new BasicStroke(1));
		g2.drawRect(50, 50, 150, 80);  // horizontal
		g2.fillRect(250, 50, 80, 150); // vertical

		// 2. Oval
		g2.setColor(Color.GREEN); // Standard color: Green
		g2.setStroke(new BasicStroke(2));
		g2.drawOval(400, 60, 150, 60);  // wide
		g2.setColor(new Color(0, 255, 0));        // Standard RGB for bright green
		g2.fillOval(600, 50, 60, 150);  // tall

		// 3. Triangle
		g2.setColor(Color.BLUE); // Standard color: Blue
		g2.setStroke(new BasicStroke(3));
		int[] xT1 = {800, 850, 900};
		int[] yT1 = {200, 100, 200};
		g2.drawPolygon(xT1, yT1, 3);  // upright triangle

		int[] xT2 = {1000, 1000, 1100};
		int[] yT2 = {100, 200, 150};
		g2.fillPolygon(xT2, yT2, 3);   // right-angled triangle

		// 4. Rounded Rectangle
		g2.setColor(Color.GREEN.darker()); // Custom color: Dark green
		g2.setStroke(new BasicStroke(4));
		RoundRectangle2D rrect = new RoundRectangle2D.Double(50, 300, 150, 80, 30, 30);
		g2.draw(rrect);

		g2.setTransform(AffineTransform.getRotateInstance(Math.toRadians(25), 300, 330)); // rotate fill
		RoundRectangle2D rrectFill = new RoundRectangle2D.Double(250, 300, 80, 150, 30, 30);
		g2.fill(rrectFill);
		g2.setTransform(new AffineTransform());

		// 5. Circle
		g2.setColor(new Color(173, 216, 230)); // Custom color: Light blue
		g2.setStroke(new BasicStroke(5));
		g2.drawOval(450, 300, 100, 100);  // perfect circle
		g2.fillOval(600, 300, 120, 80);   // stretched ellipse

		// 6. Diamond
		g2.setColor(new Color(205, 133, 63)); // Custom color: Brown-orange
		g2.setStroke(new BasicStroke(6));
		int[] xDiamond = {850, 900, 850, 800};
		int[] yDiamond = {300, 350, 400, 350};
		g2.drawPolygon(xDiamond, yDiamond, 4);  // standard diamond

		int[] xDiamond2 = {1000, 1050, 1000, 950};
		int[] yDiamond2 = {300, 350, 400, 350};
		AffineTransform original = g2.getTransform();
		g2.rotate(Math.toRadians(45), 1000, 350);  // rotated 45°
		g2.fillPolygon(xDiamond2, yDiamond2, 4); // rotated diamond
		g2.setTransform(original);  // reset

		
	}//end of method paintComponent(Graphics)

}//end of class DrawPanel