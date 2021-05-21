import java.util.InputMismatchException;

public class InputMismatchExceptonDemo {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        boolean continueInput = true;

        do {
            try{
                System.out.print("Enter an integer: ");
                int number = scanner.nextInt();

                System.out.println("The number entered is "+ number);

                continueInput = false;
            }catch (InputMismatchException e){
                System.out.println("Try again. (" +
                        "Incorrect input: an integer is required)");
                scanner.nextLine();
            }
        }while (continueInput);
    }
}
