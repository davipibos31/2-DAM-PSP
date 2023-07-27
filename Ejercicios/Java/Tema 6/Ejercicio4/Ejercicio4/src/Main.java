public class Main {
    public static void main(String[] args) {
        RunnerThread tA = new RunnerThread("A");
        RunnerThread tB = new RunnerThread("B");
        RunnerThread tC = new RunnerThread("C");

        tA.start();
        tB.start();
        tC.start();

        do {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            // Ask Thread A to finish when it reaches number 700
            if (tA.getRunnerNumber() >= 700)
                tA.setFinished(true);
            System.out.print("Thread " + tA.getRunnerName() + ": " + tA.getRunnerNumber());
            System.out.print("\tThread " + tB.getRunnerName() + ": " + tB.getRunnerNumber());
            System.out.println("\tThread " + tC.getRunnerName() + ": " + tC.getRunnerNumber());
        } while (tA.isAlive() || tB.isAlive() || tC.isAlive());
        System.out.println("The race has finished");
    }
}