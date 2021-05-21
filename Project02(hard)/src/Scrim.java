import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Scrim extends JPanel {
    private Model model;
    private Image hero;
    private Image heroU;
    private Image heroL;
    private Image heroR;
    private Image wall;
    private Image goal;
    private Image boxR;
    private Image boxB;
    private Image ground;

    public static boolean isReadBox;

    public Scrim(Model model) {


        this.model = model;
        setBackground(Color.BLACK);

        File fileNameHero = new File("./src/Images/RobotD.png");
        File fileNameHeroU = new File("./src/Images/RobotU.png");
        File fileNameHeroL = new File("./src/Images/RobotL.png");
        File fileNameHeroR = new File("./src/Images/RobotR.png");
        File fileNameWall = new File("./src/Images/Wall.png");
        File fileNameBoxB = new File("./src/Images/BoxBlue.png");
        File fileNameBoxR = new File("./src/Images/BoxRed.png");
        File fileNameGoal = new File("./src/Images/Goal.png");
        File fileNameGround = new File("./src/Images/Ground.png");

        try {

            hero = ImageIO.read(fileNameHero);
            wall = ImageIO.read(fileNameWall);
            goal = ImageIO.read(fileNameGoal);
            boxB = ImageIO.read(fileNameBoxB);
            boxR = ImageIO.read(fileNameBoxR);
            ground = ImageIO.read(fileNameGround);
            heroL = ImageIO.read(fileNameHeroL);
            heroR = ImageIO.read(fileNameHeroR);
            heroU = ImageIO.read(fileNameHeroU);


        } catch (IOException e) {
            e.printStackTrace();
        }
        setFocusable(true);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.WHITE);
        int x = 64;
        int y = 64;
        int width = 64;
        int height = 64;
        int offset = 0;

        char[][] matrix = model.getMatrix();
        for (char[] i : matrix) {
            int end = i.length - 1;
            boolean isGround = false;
            for (int j = 0; j < i.length; j++) {
                if (isGround && j < end || i[j] == '#') {
                    g.drawImage(ground, x, y, null);
                }
                switch (i[j]) {
                    case '@':
                        switch (model.getCmd()) {
                            case "Left":
                                g.drawImage(heroL, x + 13, y + 3, null);
                                break;
                            case "Right":
                                g.drawImage(heroR, x + 13, y + 3, null);
                                break;
                            case "Up":
                                g.drawImage(heroU, x + 13, y + 3, null);
                                break;
                            case "Down":
                                g.drawImage(hero, x + 13, y + 3, null);
                                break;
                        }
                        break;
                    case '#':
                        isGround = true;
                        g.drawImage(wall, x, y, null);
                        break;

                    case '$':
                        if (i[j] == '.') {
                            g.drawImage(boxR, x, y, null);
                        } else {
                            g.drawImage(boxB, x, y, null);
                        }
                        break;

                    case '.':
                        g.drawImage(goal, x + 16, y + 16, null);
                        break;
                }

                end = i[end] != '#' ? --end : end;
                x += width + offset;
            }
            x = 64;
            y += height + offset;
        }
    }
}
