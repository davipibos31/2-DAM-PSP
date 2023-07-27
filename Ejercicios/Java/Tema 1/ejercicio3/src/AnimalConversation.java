import java.util.ArrayList;
import java.util.List;

public class AnimalConversation<T extends Animal> {
    T animal1;
    T animal2;

   public void Chat(T animal1, T animal2) {
       this.animal2 = animal2;
       this.animal1 = animal1;
       System.out.println(animal1.talk());
       System.out.println(animal2.talk());
   }
}
