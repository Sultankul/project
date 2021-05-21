import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    private JButton reset;
    private JButton forward;
    private JButton backward;
    private JButton undo;
    private JButton redo;
    private JLabel level;
    private JLabel puzzle;
    public JLabel moves = new JLabel("Moves: " + Model.moves);
    private JLabel mainCosmos;
    private JLabel from;
    public JLabel movesCounter ;
    private Regulator controller;



    ControlPanel(Regulator controller) {
        Model model = controller.getModel();
        GridLayout c = new GridLayout(15, 3, 0, 10);
        setLayout(c);

        reset = new JButton("Reset (ESC)");
        forward = new JButton(">>");
        forward.setBackground(Color.GRAY);
        backward = new JButton("<<");
        backward.setBackground(Color.GRAY);
        undo = new JButton("Undo");
        undo.setBackground(Color.CYAN);
        redo = new JButton("Redo");
        redo.setBackground(Color.CYAN);

        reset.addActionListener(e -> model.startGame());
        reset.setBackground(Color.CYAN);
        reset.setFocusable(false);

        undo.addActionListener(e -> model.redoOrUndo("undo"));
        undo.setFocusable(false);
        redo.addActionListener(e -> model.redoOrUndo("redo"));
        redo.setFocusable(false);
        forward.addActionListener(e -> {
            model.getLevelParser().incLine();
            model.getLevelParser().parse();
            from.setText((Level.end + 1) + " from 40");
            model.startGame();
        });
        forward.setFocusable(false);
        backward.addActionListener(e -> {
            model.getLevelParser().decLine();
            model.getLevelParser().parse();
            from.setText((Level.end + 1) + " from 40");
            model.startGame();
        });
        backward.setFocusable(false);


        level = new JLabel("Level");
        puzzle = new JLabel("Puzzle");
        mainCosmos = new JLabel("MainCosmos");
        from = new JLabel((Level.end + 1) + " from 40");
        movesCounter = new JLabel("0");

        level.setFont(new Font("Monospaced", 1, 17));
        level.setForeground(Color.RED);
        level.setVerticalAlignment(JLabel.BOTTOM);

        puzzle.setFont(new Font("Monospaced",1, 17));
        puzzle.setForeground(Color.RED);
        puzzle.setVerticalAlignment(JLabel.BOTTOM);


        moves.setFont(new Font("Monospaced", 1, 17));
        moves.setVerticalAlignment(JLabel.BOTTOM);

        //Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
        mainCosmos.setFont(new Font("Monospaced", 1, 17));
        //mainCosmos.setBorder(border);
        mainCosmos.setOpaque(true);
        mainCosmos.setBackground(Color.BLUE);
        mainCosmos.setForeground(Color.WHITE);
        //mainCosmos.setPreferredSize(new Dimension(150, 150));
        mainCosmos.setHorizontalAlignment(JLabel.CENTER);
        mainCosmos.setVerticalAlignment(JLabel.CENTER);


        from.setFont(new Font("Monospaced", 1, 17));
        from.setOpaque(true);
        from.setBackground(Color.BLUE);
        from.setForeground(Color.CYAN);
        from.setHorizontalAlignment(JLabel.CENTER);
        from.setVerticalAlignment(JLabel.CENTER);

        movesCounter.setFont(new Font("Monospaced", 1, 17));
        movesCounter.setOpaque(true);
        movesCounter.setBackground(Color.darkGray);
        movesCounter.setForeground(Color.CYAN);
        movesCounter.setHorizontalAlignment(JLabel.CENTER);;
        movesCounter.setVerticalAlignment(JLabel.CENTER);


        add(level);
        add(mainCosmos);
        add(puzzle);
        add(from);
        add(forward);
        add(backward);
        add(moves);
        add(reset);
        add(undo);
        add(redo);



    }
}
