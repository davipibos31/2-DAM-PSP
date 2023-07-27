import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

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

        List<Student> older20 = filterStudents(list, st -> st.getAge() >= 20);
        System.out.println("Older than 20:\n" + older20);

        List<Student> prog = filterStudents(list, st -> st.getSubjects().contains("Programming"));
        System.out.println("Inscribed in programming:\n" + prog);

        List<Student> peter = filterStudents(list, st -> st.getName().toUpperCase().contains("PETER"));
        System.out.println("Name contains Peter:\n" + peter);


        //************************************************************
        // Before Java 7
        class TestPredicate implements Predicate<Student>{
            @Override
            public boolean test(Student o) {
                return o.getAge() >= 20;
            }
        }

        TestPredicate tp = new TestPredicate();
        List<Student> older20z = filterStudents(list, tp);
        System.out.println("Older than 20:\n" + older20z);

        // Java 7
        List<Student> older20x = filterStudents(list, new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getAge() >= 20;
            }
        });
        System.out.println("Older than 20:\n" + older20x);

        // Java 8 Lambda
        List<Student> older20xx = filterStudents(list, st -> st.getAge() >= 20);
        System.out.println("Older than 20:\n" + older20xx);
    }

}