import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReplaceText {
    public static void main(String[] args) {

        if (args.length != 4){
            System.out.println(
                    "Usage: java ReplaceText sourceFile targetFile oldStr newStr");
            System.exit(1);
        }

        File file = new File(args[0]);
        if (!file.exists()){
            System.out.println("Target file " + args[0] + " does not exist");
            System.exit(2);
        }

        File sFile = new File(args[1]);
        if (!sFile.exists()){
            System.out.println("Target file " + args[1] + " already exist");
            System.exit(3);
        }

        try (
            Scanner scanner = new Scanner(file);
            PrintWriter output = new PrintWriter(sFile);
        ){
            while (scanner.hasNext()){
                String s1 = scanner.nextLine();
                String s2 = s1.replaceAll(args[2],args[3]);
                output.println(s2);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
