import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 * Created by Zeno on 7/28/16.
 */
public class FinalGraph extends JFrame {
    private static JPanel imagePanel;
    private static ImageIcon background;
    // Holds our cities
    private static ArrayList destinationCities = new ArrayList<City>();

    // Adds a destination city
    public static void addCity(City city) {
        destinationCities.add(city);
    }

    // Get a city
    public static City getCity(int index){
        return (City)destinationCities.get(index);
    }

    // Get the number of destination cities
    public static int numberOfCities(){
        return destinationCities.size();
    }

    public FinalGraph(){
        super("Final Loop");
        background = new ImageIcon("USA.png");
        JLabel label = new JLabel(background);
        label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
        imagePanel = (JPanel) super.getContentPane();
        imagePanel.setOpaque(false);
        imagePanel.setLayout(new FlowLayout());
        super.getLayeredPane().setLayout(null);
        super.setSize(background.getIconWidth(), background.getIconHeight());
        super.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
        super.setLayout(new FlowLayout());
        super.setVisible(true);
        super.setLocation(800,200);
    }
    public static void drawGraph(){
        new FinalGraph();
    }
    public void drawLines(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        int n = FinalGraph.numberOfCities();
        for(int i = 0; i < n-1; i ++){
            Line2D pen = new Line2D.Float(FinalGraph.getCity(i).getX(),407-FinalGraph.getCity(i).getY(),FinalGraph.getCity(i+1).getX(),409-FinalGraph.getCity(i+1).getY()
            );
            g2.setColor(Color.BLUE);
            Stroke stroke = new BasicStroke(2f);
            g2.setStroke(stroke);
            g2.draw(pen);
        }
        Line2D pen = new Line2D.Float(FinalGraph.getCity(n-1).getX(),407-FinalGraph.getCity(n-1).getY(),FinalGraph.getCity(0).getX(),409-FinalGraph.getCity(0).getY()
        );
        g2.setColor(Color.BLUE);
        Stroke stroke = new BasicStroke(2f);
        g2.setStroke(stroke);
        g2.draw(pen);
    }
    public void paint(Graphics g) {
        super.paint(g);
        drawLines(g);
    }
}
