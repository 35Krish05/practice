import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
public class Day13 {
            public static void main(String[] args) {
                try {
                    FileReader fileReader = new FileReader("students.txt");
                    Scanner sc = new Scanner(fileReader);
                    while (sc.hasNextLine()){
                        System.out.println(sc.nextLine());
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
}



