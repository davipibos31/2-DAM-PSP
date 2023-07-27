import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        ShapeCompare<Shape> shareCompare = new ShapeCompare<>(new Circle(1), new Circle(2));
        shareCompare.compare();


    }
}