import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try (RegexReader reader = new RegexReader(
                new FileReader("dates.txt"), ".*\\d{2}/\\d{2}/(\\d{2}|\\d{4}).*");)
        {
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}