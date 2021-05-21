import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RemoveText {
    public static void main(String[] args) throws FileNotFoundException {

        if (args.length != 2) {
            System.out.println("Usage: java RemoveText sourceFile oldStr");
            System.exit(0);
        }
        File sourceFile = new File(args[0]);

        if (!sourceFile.exists()) {
            System.out.println("Source file does not exist. Program will exit. ");
            System.exit(0);
        }
        File tempFile = new File("temp_" + args[0]);

        Scanner input = new Scanner(sourceFile);

        PrintWriter output = new PrintWriter(tempFile);
        while (input.hasNext()) {
            String s1 = input.nextLine();

            String s2 = s1.replaceAll(args[1], "");
            output.println(s2);
        }
        input.close();
        output.close();
        sourceFile.delete();
        tempFile.renameTo(sourceFile);

        tempFile.delete();
    }
}
