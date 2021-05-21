import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Regulator extends KeyAdapter {
    private Model model;
    private View viewer;

    Regulator(View viewer) {
        this.viewer = viewer;
        model = new Model(viewer);

    }

    public Model getModel() {
        return model;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);

        String cmd = null;
        switch (e.getKeyCode()) {

            case KeyEvent.VK_LEFT:
                cmd = "Left";
                break;

            case KeyEvent.VK_UP:
                cmd = "Up";
                break;

            case KeyEvent.VK_RIGHT: //Virtual Keyboard
                cmd = "Right";
                break;

            case KeyEvent.VK_DOWN:
                cmd = "Down";
                break;

            case KeyEvent.VK_ESCAPE:
                cmd = "Restart";
                break;
        }
        model.move(cmd);
    }
}
