import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        List<Character> list = new ArrayList<>();
        Character f1 = new Friend();Character f2 = new Friend();
        Character f3 = new Friend();Character f4 = new Friend();
        Character f5 = new Friend();

        Character E1 = new Enemy();Character E2 = new Enemy();
        Character E3 = new Enemy();Character E4 = new Enemy();
        Character E5 = new Enemy();

        list.add(f1);list.add(f2);list.add(f3);list.add(f4);list.add(f5);
        list.add(E1);list.add(E2);list.add(E3);list.add(E4);list.add(E5);

        ListIterator<Character> iterator = list.listIterator();
        Collections.shuffle(list);

        while (iterator.hasNext()) {
            Character c1 = iterator.next();
            c1.isEnemy();
            if (c1 instanceof Enemy) {
                System.out.println("Character es un enemigo");
                ((Enemy) c1).kill();
            }
            else if (c1 instanceof Friend) {
                System.out.println("Character es un amigo");
            }
        }
    }
}