public class Main {
    public static int positiveSubtract(int n1, int n2) throws NegativeSubtractException {
        if(n1 < n2) throw new NegativeSubtractException(n1, n2);

        return n1 - n2;
    }

    public static void main(String[] args) {
        try {
            int result = positiveSubtract(4, 12);
        } catch (NegativeSubtractException e) {
            System.err.println(e.getMessage());
        }
    }
}