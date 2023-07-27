public class Square extends Shape{
    public int lado = 0;

    public Square(int lado) {
        this.lado = lado;
    }

    @Override
    int getArea() {
        return lado*lado;
    }

}
