public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Dog("Perro1");
        Animal animal2 = new Cat("Gato1");
        Animal animal3 = new Sheep("Obeja1");

        AnimalConversation con1 = new AnimalConversation();
        AnimalConversation con2 = new AnimalConversation();
        AnimalConversation con3 = new AnimalConversation();

        con1.Chat(animal1, animal2);
        System.out.println();
        con2.Chat(animal2, animal3);
        System.out.println();
        con3.Chat(animal1, animal3);
    }
}