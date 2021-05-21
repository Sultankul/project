import javax.swing.*;
import java.awt.*;

public class View {
    private Scrim canvas;
    private JFrame jFrame;
    private Regulator controller;
    private ControlPanel panel;
    private Model model;

    public View() {
        controller = new Regulator(this);
        model = controller.getModel();
        canvas = new Scrim(model);
        panel = new ControlPanel(controller);

        jFrame = new JFrame("MinSokoban");
        jFrame.setLayout(new BorderLayout());
        jFrame.add(panel, BorderLayout.EAST);
        jFrame.setFocusable(true);
        jFrame.requestFocus();
        jFrame.add(canvas, BorderLayout.CENTER);
        jFrame.setSize(900,800);
        jFrame.setLocationRelativeTo(null);
        jFrame.addKeyListener(controller);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

    }

    public void winnersWindow() {
        JOptionPane.showMessageDialog(jFrame, "Congratulations!");
    }

    public void update() {
        canvas.repaint();
    }

    public ControlPanel getPanel() {
        return panel;
    }
}
