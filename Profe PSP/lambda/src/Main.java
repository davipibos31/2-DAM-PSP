import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Hello", "Hi", "Goodbye", "Farewell", "Bye");


        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        };


        Collections.sort(list, (String s1, String s2) ->Integer.compare(s1.length(), s2.length()));

        System.out.println(list);
    }
}