import java.awt.*;
import javax.swing.JFrame;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.JComponent;
/**
 * Write a description of class FractalTree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class FractalTree extends JComponent
{
    private final int BRANCHANGLE = 100;
    private int order;
    public FractalTree(){
        JFrame frame = new JFrame();
        frame.setTitle("Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(800,800));
        frame.setVisible(true);
        frame.add(this);
        frame.pack();
    }
    
    public void drawFractal(int orderNum, double x1, double y1, double x2, double y2, Graphics2D g2, double degrees){
        if (orderNum == 0){
            return;
        }
        g2.draw(new Line2D.Double(x1, y1, x2, y2));
        Point2D.Double line1 = new Point2D.Double(x1, y1);
        Point2D.Double line2 = new Point2D.Double(x2, y2);
        
        double len = (int) (.9 * line1.distance(line2));
        
        double x3 = Math.cos(Math.toRadians(degrees)) * len + x2;
        double y3 = -Math.sin(Math.toRadians(degrees)) * len + y2;
        
        double x4 = x2 - Math.cos(Math.toRadians(degrees)) * len;
        double y4 = y2 - Math.sin(Math.toRadians(degrees)) * len;
        
        drawFractal(orderNum-1, x2, y2, x3, y3, g2, degrees - 15);
        drawFractal(orderNum-1, x2, y2, x4, y4, g2, degrees + 15);
    }
    
    public void paintComponent(Graphics g){
        g.setColor(Color.BLUE);
        Graphics2D g2 = (Graphics2D) g;
        drawFractal(2, 400, 600, 400, 450, g2, BRANCHANGLE);
    }
    
    public static void main(String[] args){
        FractalTree frame = new FractalTree();
    }
}


