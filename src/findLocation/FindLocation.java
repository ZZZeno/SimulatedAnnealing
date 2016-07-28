package findLocation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Zeno on 7/27/16.
 */
public class FindLocation {
    private static JPanel imagePanel;
    private static ImageIcon background;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Location");
        background = new ImageIcon("USA.png");
        JLabel label = new JLabel(background);
        label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
        imagePanel = (JPanel) frame.getContentPane();
        imagePanel.setOpaque(false);
        imagePanel.setLayout(new FlowLayout());
        frame.getLayeredPane().setLayout(null);
        frame.setSize(background.getIconWidth(), background.getIconHeight());
        frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setLocation(800,200);
        JLabel lb = new JLabel("Display the location of the mouse");
        frame.add(lb);
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
                if(e.getButton()==e.BUTTON3){
                    lb.setText(e.getX()+","+ (background.getIconHeight() - e.getY()));
                }
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }


        });
    }
}
