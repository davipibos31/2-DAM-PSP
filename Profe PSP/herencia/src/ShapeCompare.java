public class ShapeCompare<T extends Shape> {
    private T object;
    private T object2;

    public ShapeCompare(T obj, T obj2) {
        this.object = obj;
        this.object2 = obj2;
    }

    public void printType() {
        System.out.println("Es un" + this.object.getClass().getName());
    }

    public void compare() {
        if (this.object.getArea() > this.object2.getArea()) {
            System.out.println("El ganador es el primero");
        } else {
            System.out.println("El ganador es el segundo");
        }
    }
}
