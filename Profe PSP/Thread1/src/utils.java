public class utils {

    public static int fibbonacci(int num) {
        if (num == 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        } else {
            return fibbonacci(num - 1) + fibbonacci(num - 2);
        }
    }
}
