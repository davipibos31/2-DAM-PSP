import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static List<Student> filterStudents(List<Student> srcList,
                                               Predicate<Student> predicate) {
        List<Student> destList = new ArrayList<>();

        for(Student st: srcList) {
            if(predicate.test(st)) {
                destList.add(st);
            }
        }
        return destList;
    }

    public static List<String> getOldestNames(List<Student> list) {
        List<String> names = list.stream()
                .sorted((s1,s2)->Integer.compare(s2.getAge(),s1.getAge()))
                .limit(3)
                .map(p->p.getName())
                .collect(Collectors.toList());
        return names;
    }

    public static Set<String> getAllSubjects(List<Student> list) {
        List<String> subjects = list.stream()
                .map(Student::getSubjects)
                .reduce(new ArrayList<String>() ,(list1, list2) -> {
                    List<String> l = new ArrayList<>(list1);
                    l.addAll(list2);
                    return l;
                });
        return new TreeSet<>(subjects); // TreeSet orders by default alphabetically
    }

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Peter Pan", 23, Arrays.asList("Math","English","Programming","Philosophy")));
        list.add(new Student("Mary Lawson", 17, Arrays.asList("Physics","Spanish","Programming")));
        list.add(new Student("Sue Smith", 20, Arrays.asList("English","Literature","Philosophy")));
        list.add(new Student("John Peterson", 34, Arrays.asList("Math","Physics","Drawing","Chemistry")));
        list.add(new Student("Trevor Swanson", 19, Arrays.asList("English","Spanish","Drawing")));
        list.add(new Student("Jane Traviata", 15, Arrays.asList("Programming","Philosophy")));
        list.add(new Student("Boris Smirnoff", 26, Arrays.asList("Spanish","English","Music","Philosophy")));
        list.add(new Student("Laurent Garnier", 23, Arrays.asList("Math","Programming","Philosophy")));

        System.out.println(getAllSubjects(list));
        System.out.println(getOldestNames(list));
    }

}