import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("david", 23));
        list.add(new Student("lorena", 1));
        list.add(new Student("kilian", 2));
        list.add(new Student("Jose", 31));
        list.add(new Student("daniel", 4));
        list.add(new Student("laura", 53));
        list.add(new Student("sandra", 6));
        list.add(new Student("miguel", 70));
/*
        List<Student> listTenAge = filterAgeTen(list);


        for (Student item : listTenAge) {
            System.out.println(item.getName() + " " + item.getAge());
        }

        System.out.println();
        List<Student> listNameJ = filterNameJ(list);
        for (Student item : listNameJ) {
            System.out.println(item.getName() + " " + item.getAge());
        }
*/
        System.out.println();
        List<Student> listfil = filter(list, new Condition() {
            @Override
            public boolean accept(Student item) {
                return item.getAge() > 10;
            }
        });
        List<Student> listfil2 = filter(list, new Condition() {
            @Override
            public boolean accept(Student item) {
                return item.getName().startsWith("d");
            }
        });

        for (Student item : listfil) {
            System.out.println(item.getName() + " " + item.getAge());
        }
        System.out.println();
        for (Student item : listfil2) {
            System.out.println(item.getName() + " " + item.getAge());
        }
    }

    /*
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
            if (item.getName().startsWith("d")) {
                list.add(item);
            }
        }
        return list;
    }
*/
    public static List<Student> filter(List<Student> array, Condition condition) {
        List<Student> list = new ArrayList<>();
        for (Student item : array) {
            if (condition.accept(item)) {
                list.add(item);
            }
        }
        return list;
    }
}