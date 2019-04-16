import java.awt.*;
import javax.swing.JFrame;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
/**
 * Write a description of class FractalTree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class FractalTree
{
    private final int BRANCHANGLE = 15;
    private final double BRANCHSUBTRACTION = 10;
    private int order;
    public FractalTree(){
        JFrame frame = new JFrame();
        frame.setTitle("Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setVisible(true);
        
        
       
    }
    
    public void drawFractal(int orderNum, double x1, double y1, double x2, double y2, Graphics g){
        order = orderNum;
        if (order == 0){
            return;
        }
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(new Line2D.Double(x1, y1, x2, y2));
        
        
    }
    
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLUE);
        drawFractal(1, 400, 600, 400, 300, g2);
    }
    public static void main(String[] args){
        FractalTree frame = new FractalTree();
    }
}


