import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Problem03 extends JFrame {

    Problem03() {
        setSize(400, 400);
        setLocationRelativeTo(null);
        setTitle("Third GUI App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel mainP = new JPanel();
        mainP.setBackground(Color.DARK_GRAY);
        mainP.addMouseMotionListener(new MouseMotionAdapter() {

            public void mouseMoved(MouseEvent e) {
                setTitle(e.getX() + ", " + e.getY());
            }
        });

        add(mainP, "Center");

    }

    public static void main(String[] args) {
        new Problem03().setVisible(true);
    }
}