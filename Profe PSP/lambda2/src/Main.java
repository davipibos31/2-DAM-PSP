import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Jose", 19, Arrays.asList("PSP", "PMD", "Programación")));
        list.add(new Student("fose", 18, Arrays.asList("PSP", "PMD", "three")));
        list.add(new Student("tose", 35, Arrays.asList("Programación", "PMD", "three")));
        list.add(new Student("Jose", 10, Arrays.asList("PSP", "PMD", "Programación")));
        list.add(new Student("mose", 7, Arrays.asList("PSP", "Programación", "three")));
        list.add(new Student("jose", 21, Arrays.asList("PSP", "PMD", "three")));

       /* List<Student> listTenAge = filterAgeTen(list);
        System.out.println("filterAgeTen *****************************");
        for (Student item : listTenAge) {
            System.out.println(item.getName() + " " + item.getAge());
        }
        List<Student> listNameJ = filterNameJ(list);
        System.out.println("filterNameJ *****************************");
        for (Student item : listNameJ) {
            System.out.println(item.getName() + " " + item.getAge());
        }
        List<Student> listfilter2 = filter(list, new Condition() {
            @Override
            public boolean accept(Student item) {
                return false;
            }
        });*/

        list.stream().filter(new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return false;
            }
        });



        List<Student> listfilter = filter(list, (Student item) -> item.getAge() > 20);
        List<Student> listfilter2 = filter(list, (Student item) -> item.getSubjects().contains("Programación"));


        List<Student> listfilter3 = filterStudents(list, (Student item) -> item.getName().contains("Peter"));


        filterStudents(list, new Predicate<Student>() {
            @Override
            public boolean test(Student item) {
                return  item.getName().contains("Peter");
            }
        });
        filter(list, new Condition() {
            @Override
            public boolean accept(Student student) {
                return false;
            }
        });
        System.out.println("listfilter *****************************");
        for (Student item : listfilter) {
            System.out.println(item.getName() + " " + item.getAge());
        }
    }

    public static List<Student> filterAgeTen(List<Student> array) {
        List<Student> list = new ArrayList<>();
        for (Student item : array) {
            if (item.getAge() > 10) {
                list.add(item);
            }
        }
        return list;
    }

    public static List<Student> filterNameJ(List<Student> array) {
        List<Student> list = new ArrayList<>();
        for (Student item : array) {
            if (item.getName().startsWith("J")) {
                list.add(item);
            }
        }
        return list;
    }

    public static List<Student> filter(List<Student> array, Condition condition) {
        List<Student> list = new ArrayList<>();
        for (Student item : array) {
            if (condition.accept(item)) {
                list.add(item);
            }
        }
        return list;
    }

    public static List<Student> filterStudents(List<Student> array, Predicate<Student> condition) {
        List<Student> list = new ArrayList<>();
        for (Student item : array) {
            if (condition.test(item)) {
                list.add(item);
            }
        }
        return list;
    }
}