public class Counter {
    private int num = 0;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Counter(int num) {
        this.num = num;
    }
    public synchronized void increment() {
        this.num++;
    }
    public synchronized void decrement() {
        this.num--;
    }

    public int getValue() {
        return num;
    }
}
