import javax.swing.*;
import java.awt.*;

public class Problem02 extends JFrame {


    Problem02() {
        setSize(400, 400);
        setLocationRelativeTo(null);
        setTitle("Second GUI App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel mainP = new JPanel();
        mainP.setBackground(Color.RED);

        JPanel toolbarP = new JPanel();
        toolbarP.setBackground(Color.GRAY);

        JButton redB = new JButton("RED");
        redB.addActionListener(e -> mainP.setBackground(Color.RED));

        JButton greenB = new JButton("GREEN");
        greenB.addActionListener(e -> mainP.setBackground(Color.GREEN));

        JButton blueB = new JButton("BLUE");
        blueB.addActionListener(e -> mainP.setBackground(Color.BLUE));

        toolbarP.add(redB);
        toolbarP.add(greenB);
        toolbarP.add(blueB);

        add(mainP, "Center");
        add(toolbarP, "South");

    }

    public static void main(String[] args) {
        new Problem02().setVisible(true);
    }
}
