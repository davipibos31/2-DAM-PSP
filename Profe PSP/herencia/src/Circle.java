public class Circle extends Shape {
    private int radio = 0;

    public Circle(int radio) {
        this.radio = radio;
    }

    @Override
    int getArea() {
        return radio * radio * 3;
    }

}
