import java.util.ArrayList;
import java.util.Scanner;

public class Problem03 {
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(0, 0, 100, 100));
        shapes.add(new Rectangle(40, 40, 50, 70));
        shapes.add(new Circle(100,200,20));
        shapes.add(new Circle(40,60,20));


        while (true) {
            System.out.print("x: ");
            int x = sc.nextInt();
            System.out.print("y: ");
            int y = sc.nextInt();
            if(x == -1 && y == -1){
                break;
            }

            for(Shape shape : shapes){
                if(shape.contains(x, y)){
                    System.out.println(shape);
                }
            }

        }

    }
}
