import java.util.ArrayList;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("CatchMayIgnoreException")
public class Search extends RecursiveTask<ArrayList<String>> {
    /* How many video games will each task be in charge of? */
    public static final int MAX_GAMES = 5;
    /* List of video games */
    ArrayList<String> list;
    /* First index of the list to search */
    int first;
    /* Last index of the list to search */
    int last;
    /* Text to be searched in the list */
    String text;
    public Search(ArrayList<String> list, String text, int first, int last) {
        this.list = list;
        this.text = text;
        this.first = first;
        this.last = last;
    }
    @Override
    protected ArrayList<String> compute() {
        //noinspection Convert2Diamond
        ArrayList<String> results = new ArrayList<String>();
        if (last - first <= MAX_GAMES)
            results = search();
        else {
            int middle = (first + last) / 2;
            System.out.println("Creating 2 subtasks...");
            Search s1 = new Search(list, text, first, middle + 1);
            Search s2 = new Search(list, text, middle + 1, last);
            invokeAll(s1, s2);
            try {
                results = s1.get();
                ArrayList<String> aux = s2.get();
                results.addAll(aux);
            } catch (Exception e) { }
        }
        return results;
    }
    public ArrayList<String> search() {
        //noinspection Convert2Diamond
        ArrayList<String> results = new ArrayList<String>();
        for (int i = first; i < last; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) { }
            if (list.get(i).contains("java"))
            {
                results.add("Found at " + i + ": " + list.get(i).replace("java", "Java"));
            }
        }
        return results;
    }
}