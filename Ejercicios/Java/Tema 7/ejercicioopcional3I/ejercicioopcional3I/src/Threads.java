public class Threads extends Thread{
    int cont=0;
    boolean terminado = false;
    @Override
    public void run() {
        while (cont<200){
            cont++;
            try {
                //noinspection BusyWait
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public int getCont() {
        return cont;
    }

    @SuppressWarnings("unused")
    public boolean isTerminado() {
        return terminado;
    }
}