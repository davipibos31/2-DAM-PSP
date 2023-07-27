import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        PrintWriter print = null;
        BufferedReader buffer = null;

        try {
            buffer = new BufferedReader(new FileReader("test.txt"));
            print = new PrintWriter(new FileWriter("in.txt"));
            String line;
            while ((line = buffer.readLine()) != null) {
                print.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error writing: " + e.getMessage());
        } finally {
            if (buffer != null) {
                buffer.close();
            }
            if (print != null) {
                print.close();
            }
        }
    }
}