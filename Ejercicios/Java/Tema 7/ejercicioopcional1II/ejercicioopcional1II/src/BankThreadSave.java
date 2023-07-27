public class BankThreadSave extends Thread {
    BankAccount account;

    public BankThreadSave(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.addMoney(100);
            //noinspection CatchMayIgnoreException
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }
    }
}
