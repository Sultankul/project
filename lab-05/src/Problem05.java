import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Movement {
    private int row;
    private int col;

    int getRow() {
        return row;
    }

    int getCol() {
        return col;
    }

    void moveRight() {
        if (this.col < 7) {
            this.col++;
        }
    }

    void moveLeft() {
        if (this.col > 0) {
            this.col--;
        }
    }

    void moveUp() {
        if (this.row > 0) {
            this.row--;
        }
    }

    void moveDown() {
        if (this.row < 7) {
            this.row++;
        }
    }
}

public class Problem05 extends JFrame {
    Movement move;
    RobotCanvas canvasPanel;

    class RobotCanvas extends JPanel {
        protected void paintComponent(final Graphics g) {
            super.paintComponent(g);

            final int cellW = this.getWidth() / 8;
            final int cellH = this.getHeight() / 8;
            for (int i = 0; i < 8; ++i) {
                for (int j = 0; j < 8; ++j) {
                    Color color;
                    if (i % 2 == 0) {
                        color = ((j % 2 == 0) ? Color.BLACK : Color.WHITE);
                    } else {
                        color = ((j % 2 == 0) ? Color.WHITE : Color.BLACK);
                    }
                    g.setColor(color);
                    g.fillRect(cellW * j, cellH * i, cellW, cellH);
                }
            }
            g.setColor(Color.RED);
            g.fillOval(cellW * move.getCol(), cellH * move.getRow(), cellW, cellH);
        }
    }
    Problem05() {
        setTitle("Fifth GUI App");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        move = new Movement();
        (canvasPanel = new RobotCanvas()).setFocusable(true);
        add(canvasPanel);
        canvasPanel.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == 39) {
                    move.moveRight();
                } else if (keyEvent.getKeyCode() == 37) {
                    move.moveLeft();
                } else if (keyEvent.getKeyCode() == 38) {
                    move.moveUp();
                } else if (keyEvent.getKeyCode() == 40) {
                    move.moveDown();
                }
                repaint();
            }
        });
    }


    public static void main(String[] args) {
        new Problem05().setVisible(true);
    }
}