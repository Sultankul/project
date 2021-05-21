import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Level {
    private int line = 0;
    public static int end = 0;
    ArrayList<Integer> indexes = new ArrayList<>(40);

    public char[][] parse() {
        File file = new File("./src/Levels/MiniCosmos (Build first 3 puzzles into the program).txt");
        List<Character> symbols = Arrays.asList('.', '#', '@', ' ', '$', '*');
        List<String> list = new ArrayList<>();

        StringBuilder c = new StringBuilder();
        boolean throwException = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line; // читаем файл по строчкам
            int lineCounter = 0;
            while ((line = reader.readLine()) != null) { // будем продолжать считывать файл, пока не достигнем последней строки
                line = line.replaceAll("[A-Za-z;]".trim(), "");
                if (!line.replaceAll(" ", "").isEmpty()) {
                    list.add(line);
                    lineCounter++;
                }
                if (line.matches(".*\\d.*")) {
                    indexes.add(lineCounter);
                }
                if (!line.matches("[.s@$#*\\d]")) {
                    for (int i = 0; i < line.length(); i++) {
                        if (!symbols.contains(line.charAt(i)) && !Character.isDigit(line.charAt(i))) {
                            c.append("(" + lineCounter + ", " + (i + 1) + ") - ' " + line.charAt(i) + " '\n");
                            throwException = true;
                        }
                    }
                }
                if (line.length() < 8 && !line.matches(".*\\d.*") && !line.isEmpty()) {
                    for (int i = 0; i < 8 - line.length(); i++) {
                        list.set(lineCounter - 1, line + " ");
                    }
                }

            }// на выходе получаем arraylist содержайщий в себе строки , которые содержат только чары)
            if (throwException) {
                JOptionPane.showMessageDialog(null, "Incorrect Data\n" + c + "\n");
                //throw new RuntimeException();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
        } catch (IOException e) {
            System.out.println("Ошибка");
        }



        char[][] result = new char[indexes.get(end + 1) - indexes.get(end)][];
        for (int row = 0; row < indexes.get(end + 1) - indexes.get(end); row++) {
            result[row] = list.get(row + indexes.get(end)).toCharArray();
        }
        System.out.println(indexes.get(end));
        // System.out.println();
        // += 8;
        return result; //на выходе получили двумерный массив ,содержащий только чары!
    }

    public void incLine() {
        if (end + 1 < 40) {
            end++;
        }
    }

    public void decLine() {
        if (end >= 1) {
            end--;
        }
    }
}
