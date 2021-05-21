import javax.swing.*;
import java.awt.*;

class Canvas extends JPanel {
//    private static final int FIELD_WIDTH = 10;
//    private static final int FIELD_HEIGHT = 10;

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
/*
        int cellSize = Math.min(getWidth() / FIELD_WIDTH, getHeight() / FIELD_HEIGHT);
        int screenFieldWidth = FIELD_WIDTH * cellSize;
        int screenFieldHeight = FIELD_HEIGHT * cellSize;
        int centeringShiftX = (int) ((getWidth() - screenFieldWidth) / 2f);
        int centeringShiftY = (int) ((getHeight() - screenFieldHeight) / 2f);
*/
        int cellW = getWidth() / 8;
        int cellH = getHeight() / 8;

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
//                int screenX = cellSize * x + centeringShiftX;
//                int screenY = cellSize * y + centeringShiftY;
                Color color;
                if (y % 2 == 0) {
                    color = ((x % 2 == 0) ? Color.BLACK : Color.WHITE);
                } else {
                    color = ((x % 2 == 0) ? Color.WHITE : Color.BLACK);
                }
                g.setColor(color);
                g.fillRect(cellW * x, cellH * y, cellW, cellH);
//                g.fillRect(screenX, screenY, cellSize, cellSize);

            }
        }
    }
}

public class Problem04 extends JFrame {
    Problem04() {
        setSize(400, 400);
        setLocationRelativeTo(null);
        setTitle("Forth GUI App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel mainP = new Canvas();
        mainP.setBackground(Color.GRAY);

        add(mainP, "Center");

    }

    public static void main(String[] args) {
        new Problem04().setVisible(true);
    }
}
