import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int age;
    private List<String> subjects;

    public Student(String name, int age, List<String> subjects) {
        this.name = name;
        this.age = age;
        this.subjects = new ArrayList<>(subjects);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    @Override
    public String toString() {
        return getName() + "(" + getAge() + ") -> " + subjects + "\n";
    }
}