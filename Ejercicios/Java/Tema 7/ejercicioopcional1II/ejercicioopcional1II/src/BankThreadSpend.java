public class BankThreadSpend extends Thread{
    BankAccount account;

    public BankThreadSpend(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.takeOutMoney(100);
            //noinspection CatchMayIgnoreException
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }
    }
}
