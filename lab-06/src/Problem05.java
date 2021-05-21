import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Problem05 extends JFrame {
    private final static int MIN_RECT_SIZE = 8;
    private final static int MAX_RECT_SIZE = 80;
    private final static int MIN_CIRCLE_RADIUS = 8;
    private final static int MAX_CIRCLE_RADIUS = 40;

    private final ArrayList<Shape> shapes = new ArrayList<>();
    private Shape selectedShape = null;
    private boolean isDragging = false;
    private int mouseDX, mouseDY;

    class Canvas extends JPanel {
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHints(new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON)
            );

            super.paintComponent(g);

            for (Shape shape : shapes) {
                if (shape instanceof Rectangle) {
                    Rectangle rect = (Rectangle) shape;
                    g.setColor(Color.RED);
                    g.fillRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
                    if (shape == selectedShape) {
                        g.setColor(Color.BLACK);
                        g.drawRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());

                    }
                } else if (shape instanceof Circle) {
                    Circle circle = (Circle) shape;
                    g.setColor(Color.YELLOW);
                    g.fillOval(circle.getX(), circle.getY(), circle.getR() * 2, circle.getR() * 2);
                    if (shape == selectedShape) {
                        g.setColor(Color.BLACK);
//                        g2.setStroke(new BasicStroke(3)); //how thick the border is
                        g.drawOval(circle.getX(), circle.getY(), circle.getR() * 2, circle.getR() * 2);
                    }
                } else if (shape instanceof Cross) {
                    Cross cross = (Cross) shape;
                    g.setColor(Color.BLUE);
                    g.fillRect(cross.getX(), cross.getY(), cross.getWidth(), cross.getHeight());
                    g.fillRect(cross.getX2(), cross.getY2(), cross.getWidth2(), cross.getHeight2());
                    if (shape == selectedShape) {
                        g.setColor(Color.BLACK);
                        g.drawRect(cross.getX(), cross.getY(), cross.getWidth(), cross.getHeight());
                        g.drawRect(cross.getX2(), cross.getY2(), cross.getWidth2(), cross.getHeight2());
                    }
                }
            }
        }
    }

    Problem05() {
        setSize(500, 500);
        setTitle("Graph Editor");
        setLocationRelativeTo(null);  //center of the screen
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JFrame thisFrame = this;

        JPanel canvas = new Canvas();
        canvas.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                selectedShape = null;
                for (Shape shape : shapes) {
                    if (shape.contains(e.getX(), e.getY())) {
                        selectedShape = shape;
                    }
                }
                if (selectedShape != null) {
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        isDragging = true;
                        mouseDX = selectedShape.getX() - e.getX();
                        mouseDY = selectedShape.getY() - e.getY();
                    } else if (e.getButton() == MouseEvent.BUTTON3) {
                        JOptionPane.showMessageDialog(thisFrame, selectedShape);
                    }
                }
                repaint();
            }

            public void mouseReleased(MouseEvent e) {
                isDragging = false;
            }

        });

        canvas.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (isDragging) {
                    selectedShape.move(e.getX() + mouseDX, e.getY() + mouseDY);
                    repaint();
                }
            }
        });

        canvas.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (selectedShape != null) {
                    if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                        shapes.remove(selectedShape);
                        selectedShape = null;
                        repaint();
                    }
                }
            }
        });

        JPanel toolBar = new JPanel();

        JButton bRect = new JButton("RECT");
        bRect.addActionListener(e -> {
            int width = (int) (MIN_RECT_SIZE + Math.random() * (MAX_RECT_SIZE - MIN_RECT_SIZE + 1));
            int height = (int) (MIN_RECT_SIZE + Math.random() * (MAX_RECT_SIZE - MIN_RECT_SIZE + 1));
            int x = (int) (Math.random() * canvas.getWidth() - width);
            int y = (int) (Math.random() * canvas.getHeight() - height);
            shapes.add(new Rectangle(x, y, width, height));
            repaint();
            canvas.requestFocus();

        });

        JButton bCircle = new JButton("CIRCLE");
        bCircle.addActionListener(e -> {
            int r = (int) (MIN_CIRCLE_RADIUS + Math.random() * (MAX_CIRCLE_RADIUS - MIN_CIRCLE_RADIUS + 1));
            int x = (int) (Math.random() * canvas.getWidth() - r * 2);
            int y = (int) (Math.random() * canvas.getHeight() - r * 2);
            shapes.add(new Circle(x, y, r));
            repaint();
            canvas.requestFocus();

        });
        JButton bCross = new JButton("CROSS");
        bCross.addActionListener(e -> {
            int width = (int) (MIN_RECT_SIZE + Math.random() * (MAX_RECT_SIZE - MIN_RECT_SIZE + 1));
            int height = (int) (MIN_RECT_SIZE + Math.random() * (MAX_RECT_SIZE - MIN_RECT_SIZE + 1));
            int x = (int) (Math.random() * canvas.getWidth() - width);
            int y = (int) (Math.random() * canvas.getHeight() - height);
            shapes.add(new Cross(x, y, width, height));
            repaint();
            canvas.requestFocus();

        });

        toolBar.add(bRect);
        toolBar.add(bCircle);
        toolBar.add(bCross);

        add(canvas, "Center");
        add(toolBar, "South");


    }

    public static void main(String[] args) {
        new Problem05().setVisible(true);
    }
}
