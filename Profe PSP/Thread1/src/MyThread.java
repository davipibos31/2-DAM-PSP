public class MyThread extends Thread{
    private String name;
    private int num = 0;
    private boolean cancelled = false;

    public MyThread(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10 && !this.cancelled; i++) {
            try {
                this.sleep((int) (Math.random() * 10));
                System.out.println(this.name+" "+num);
                num = i;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int getValue() {
        return num;
    }
}
