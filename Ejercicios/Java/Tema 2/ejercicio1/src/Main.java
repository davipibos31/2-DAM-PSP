import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Map<Company, Set<Person>> cMap = new TreeMap<>(new Comparator<Company>() {
            @Override
            public int compare(Company c1, Company c2) {
                return Double.compare(c1.getMoney(), c2.getMoney());
            }
        });

        Comparator<Person> personComp = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return Integer.compare(p1.getAge(), p2.getAge());
            }
        };

        Set<Person> auxSet = new TreeSet<>(personComp);
        auxSet.add(new Person("Peter", 49));
        auxSet.add(new Person("John", 34));
        auxSet.add(new Person("Anne", 37));
        cMap.put(new Company("Berberechos S.A.", 20000.55), auxSet);

        auxSet = new TreeSet<>(personComp);
        auxSet.add(new Person("Mary", 28));
        auxSet.add(new Person("Loise", 89));
        auxSet.add(new Person("Sherlock", 19));
        cMap.put(new Company("Drunks Alltime Corp.", 40.90), auxSet);

        auxSet = new TreeSet<>(personComp);
        auxSet.add(new Person("Julius", 29));
        auxSet.add(new Person("Sue", 26));
        auxSet.add(new Person("Homer", 27));
        cMap.put(new Company("Hello World Company", 14000.95), auxSet);

        // It shows the data

        for (Company c : cMap.keySet()) {
            System.out.println(c.getName() + ", money: " + c.getMoney() + ":");

            for (Person p : cMap.get(c)) {
                System.out.println("\t" + p.getName() + ", age: " + p.getAge());
            }
        }

        System.out.println("Another way to show the data: ----------");

        for (Map.Entry<Company, Set<Person>> set : cMap.entrySet()) {
            Company c = set.getKey();
            System.out.println(c.getName() + ", money: " + c.getMoney() + ":");
            for (Person p : set.getValue()) {
                System.out.println("\t" + p.getName() + ", age: " + p.getAge());
            }
        }
    }
}