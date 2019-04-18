import java.awt.*;
import javax.swing.JFrame;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.JComponent;
/**
 * Program that creates and displays a fractal tree
 *
 * @author tsnissanka
 * @version 4/15/19
 */

public class FractalTree extends JComponent
{
    private double branchLength;
    private final double ANGLESCALE = .9;
    private int maxOrder = 10;
    private final int ANGLECHANGE = 39;
    private final int WIDTH = 800;
    private final int HEIGHT = 800;
    /**
     * Constructs a FractalTree with default parameters
     */
    public FractalTree(){
        branchLength = 50;
        JFrame frame = new JFrame();
        frame.setTitle("Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        frame.setVisible(true);
        frame.add(this);
        frame.pack();
    }
    
    /**
     * Draws a fractal tree recursively
     * 
     * @param orderNum order from which to start drawing tree
     * @param x x coordinate of starting point
     * @param y y coordinate of starting point
     * @param g2 graphics object which draws tree
     * @param angle the angle with which the branches rotate
     * @param len the length of the branches
     */
    public void drawFractal(int orderNum, double x1, double y1, Graphics2D g2, double angle, double len){
        if (orderNum >= maxOrder){
            return;
        }
        double rightAng = angle - ANGLECHANGE * ANGLESCALE;
        double leftAng = angle + ANGLECHANGE * ANGLESCALE;
        
        
        if(orderNum == 0){
            rightAng = 0;
            leftAng = 0;
        }
        
        double x2 = x1 - len * Math.sin(Math.toRadians(rightAng));
        double y2 = y1 - len * Math.cos(Math.toRadians(rightAng));
        
        double x3 = x1 - len * Math.sin(Math.toRadians(leftAng));
        double y3 = y1 - len * Math.cos(Math.toRadians(leftAng));
        
        g2.draw(new Line2D.Double(x1, y1, x2, y2));
        g2.draw(new Line2D.Double(x1, y1, x3, y3));
        
        double newLen = len - (len/15);
        
        drawFractal(orderNum + 1, x3, y3, g2, leftAng, newLen);
        drawFractal(orderNum + 1, x2, y2, g2, rightAng, newLen);
    }
    
    /**
     * Draws a black background, changes pen color to magenta, calls drawFractal method which draws fractal tree
     * @param g graphics variable used to draw
     */
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, WIDTH, HEIGHT);
        g2.setColor(Color.MAGENTA);
        drawFractal(0, 400, 600, g2, 0, this.branchLength);
    }
    
    public static void main(String[] args){
        FractalTree frame = new FractalTree();
    }
}


