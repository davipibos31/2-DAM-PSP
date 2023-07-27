public class Threads1 extends Thread{
    public Threads1() {
    }

    public static int fibbonacci(int num) {
        if (num == 0) {
            return 0;
            //CASO BASE, si es 1 devuelve un 1
        } else if (num == 1) {
            return 1;
        } else {
            //Hago la suma
            return fibbonacci(num - 1) + fibbonacci(num - 2);
        }
    }
}
