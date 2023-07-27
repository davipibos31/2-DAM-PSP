import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Comment> comments = new ArrayList<>();

        ZonedDateTime zonedAux;
        ZoneId madrid = ZoneId.of("Europe/Madrid");
        String line;
        String[] data, dateParts, timeParts;
        try (BufferedReader reader = new BufferedReader(
                new FileReader("comments.txt"));) {

            while ((line = reader.readLine()) != null) {
                data = line.split(";");
                dateParts = data[2].split("/");
                timeParts = data[3].split(":");

                zonedAux = ZonedDateTime.of(
                        Integer.parseInt(dateParts[2]),
                        Integer.parseInt(dateParts[1]) - 1,
                        Integer.parseInt(dateParts[0]),
                        Integer.parseInt(timeParts[0]),
                        Integer.parseInt(timeParts[1]),
                        Integer.parseInt(timeParts[2]), 0,
                        ZoneId.of(data[4]));

                comments.add(new Comment(data[0], data[1],
                        zonedAux.withZoneSameInstant(madrid)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(comments, new Comparator<Comment>() {
            public int compare(Comment c1, Comment c2) {
                long diff = c2.getTime().until(c1.getTime(), ChronoUnit.SECONDS); // c1 - c2
                return Long.compare(diff, 0); // Positive -> 1, negative -> -1, equal -> 0
            }
        });

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy;HH:mm:ss;VV");

        try (PrintWriter writer = new PrintWriter(new FileWriter("ordered_comments.txt", false))) {
            for (Comment c : comments) {
                writer.println(c.getUsername() + ";" + c.getText() +
                        ";" + c.getTime().format(formatter));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
