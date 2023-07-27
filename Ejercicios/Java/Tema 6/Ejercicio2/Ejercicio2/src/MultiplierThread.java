public class MultiplierThread extends Thread {
    int number;

    public MultiplierThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++)
            System.out.println(number + " x " + i + " = " + (number * i));
    }
}
