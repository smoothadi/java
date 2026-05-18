import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFiles {

    private static final String[] BAD_WORDS = {"dog", "monkey", "donkey"};

    public static void main(String[] args) {
        String filePath = "god.txt";

        if (isFileSafe(filePath)) {
            readFile(filePath);
        } else {
            System.out.println("Lady Muthu.");
        }
    }

    private static boolean isFileSafe(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String lowerLine = line.toLowerCase();

                for (String badWord : BAD_WORDS) {
                    if (lowerLine.contains(badWord)) {
                        return false;
                    }
                }
            }
            return true;

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return false;
        }
    }

    private static void readFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
