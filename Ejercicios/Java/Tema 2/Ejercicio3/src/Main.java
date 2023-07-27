import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Double> array  = new ArrayList<>();
        List<Double> linked = new LinkedList<>();

        Instant start = Instant.now();
        // Some operation
        for(int i = 0; i < 100000; i++) {
            array.add(0, Math.random());
        }
        Instant end = Instant.now();

        Duration dur = Duration.between(start, end);
        System.out.printf("Array list, add 100.000 items: %dms\n", dur.toMillis());

        start = Instant.now();
        for(int i = 0; i < 100000; i++) {
            linked.add(0, Math.random());
        }
        end = Instant.now();
        dur = Duration.between(start, end);
        System.out.printf("Linked list, add 100.000 items: %dms\n", dur.toMillis());

        start = Instant.now();
        for(int i = 0; i < 50000; i++) {
            array.remove(0);
        }
        end = Instant.now();
        dur = Duration.between(start, end);
        System.out.printf("Array list, delete first 50.000 items: %dms\n", dur.toMillis());

        start = Instant.now();
        for(int i = 0; i < 50000; i++) {
            linked.remove(0);
        }
        end = Instant.now();
        dur = Duration.between(start, end);
        System.out.printf("Linked list, delete first 50.000 items: %dms\n", dur.toMillis());

        int pos;
        start = Instant.now();
        for(int i = 0; i < 50000; i++) {
            pos = (int)(Math.random()*(50000+i));
            array.add(pos, Math.random());
        }
        end = Instant.now();
        dur = Duration.between(start, end);
        System.out.printf("Array list, insert 50.000 items in aleatory positions: %dms\n", dur.toMillis());

        start = Instant.now();
        for(int i = 0; i < 50000; i++) {
            pos = (int)(Math.random()*(50000+i));
            linked.add(pos, Math.random());
        }
        end = Instant.now();
        dur = Duration.between(start, end);
        System.out.printf("Linked list, insert 50.000 items in aleatory positions: %dms\n", dur.toMillis());

        start = Instant.now();
        for(int i = 1; i <= 50000; i++) {
            pos = (int)(Math.random()*(100000-i));
            array.remove(pos);
        }
        end = Instant.now();
        dur = Duration.between(start, end);
        System.out.printf("Array list, delete 50.000 aleatory items: %dms\n", dur.toMillis());

        start = Instant.now();
        for(int i = 1; i <= 50000; i++) {
            pos = (int)(Math.random()*(100000-i));
            linked.remove(pos);
        }
        end = Instant.now();
        dur = Duration.between(start, end);
        System.out.printf("Linked list, delete 50.000 aleatory items: %dms\n", dur.toMillis());

        Iterator<Double> arrayIt = array.iterator();
        Iterator<Double> linkedIt = linked.iterator();
        int i = 0;

        start = Instant.now();
        while(arrayIt.hasNext()) {
            arrayIt.next();
            if(i % 2 == 0) arrayIt.remove();
            i++;
        }
        end = Instant.now();
        dur = Duration.between(start, end);
        System.out.printf("Array list, delete even position items (iterator): %dms\n", dur.toMillis());

        i = 0;

        start = Instant.now();
        while(linkedIt.hasNext()) {
            linkedIt.next();
            if(i % 2 == 0) linkedIt.remove();
            i++;
        }
        end = Instant.now();
        dur = Duration.between(start, end);
        System.out.printf("Linked list, delete even position items (iterator): %dms\n", dur.toMillis());
    }
}