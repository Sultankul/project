import javax.swing.*; //done! need to commit!
import java.awt.*;

public class Problem01 extends JFrame {
    Problem01(){
        setSize(400, 400);
        setLocationRelativeTo(null);
        setTitle("First GUI App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel mainP = new JPanel();
        mainP.setBackground(Color.RED);

        JPanel toolbarP = new JPanel();
        toolbarP.setBackground(Color.GRAY);

        JButton redB = new JButton("RED");
        JButton greenB = new JButton("GREEN");
        JButton blueB = new JButton("BLUE");

        toolbarP.add(redB);
        toolbarP.add(greenB);
        toolbarP.add(blueB);

        add(mainP, "Center");
        add(toolbarP, "South");

    }
    public static void main(String[] args) {
        new Problem01().setVisible(true);
    }
}
