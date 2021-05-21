import java.util.ArrayList;
import java.util.Scanner;

public class Problem01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Rectangle> rect = new ArrayList<>();
        rect.add(new Rectangle(0, 0, 100, 100));
        rect.add(new Rectangle(40, 40, 50, 70));

        while (true) {
            System.out.print("x: ");
            int x = sc.nextInt();
            System.out.print("y: ");
            int y = sc.nextInt();
            if (x == -1 && y == -1) {
                break;
            }

            for (Rectangle rectangle : rect) {
                if (rectangle.contains(x, y)) {
                    System.out.println(rectangle);
                }
            }

        }

    }
}
