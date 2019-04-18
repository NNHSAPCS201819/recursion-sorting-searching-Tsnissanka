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
    private int branchLength;
    private final double ANGLESCALE = .9;
    private int maxOrder = 10;
    private final int ANGLESUB = 39;
    private final int WIDTH = 800;
    private final int HEIGHT = 800;
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
    
    public void drawFractal(int orderNum, double x1, double y1, Graphics2D g2, double angle){
        if (orderNum >= maxOrder){
            return;
        }
        double rightAng = angle - ANGLESUB * ANGLESCALE;
        double leftAng = angle + ANGLESUB * ANGLESCALE;
        
        double len = branchLength * .8;
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
        
        
        drawFractal(orderNum + 1, x3, y3, g2, leftAng);
        drawFractal(orderNum + 1, x2, y2, g2, rightAng);
    }
    
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, WIDTH, HEIGHT);
        g2.setColor(Color.MAGENTA);
        drawFractal(0, 400, 600, g2, 0);
    }
    
    public static void main(String[] args){
        FractalTree frame = new FractalTree();
    }
}


