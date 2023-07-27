import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static Callable<List<String>> getSumCallable(String url) {
        return () -> {
            List<String> list = LinkReader.getLinks(url);
            return list;
        };
    }

    public static Callable<WebPage> completeWebPage(WebPage wp) {
        return () -> {
            wp.setLinks(LinkReader.getLinks(wp.getUrl()));
            return wp;
        };
    }

    public static void main(String[] args) throws InterruptedException {
        List<Callable<WebPage>> callables = Arrays.asList(
                completeWebPage(new WebPage("futbol","https://aa.futbol.nu")),
                completeWebPage(new WebPage("marca","https://marca.com")),
                completeWebPage(new WebPage("marca","https://marca.com")),
                completeWebPage(new WebPage("koora","https://www.koora.live")),
                completeWebPage(new WebPage("elpais","https://www.elpais.com"))
        );
        ExecutorService executor = Executors.newFixedThreadPool(10);
        // Calling submit executes the thread and returns a Future
        List<Future<WebPage>> futures = executor.invokeAll(callables);
        executor.shutdown();

        futures.forEach(future -> {
            try {
                WebPage wp = future.get();
                System.out.println("Nombre: "+wp.getName()+" " +
                        "url:"+wp.getUrl()+" " +
                        "total:"+wp.getLinks().size());
            } catch (InterruptedException | ExecutionException e) {
                throw new IllegalStateException(e);
            }
        });

    }




        /*System.out.println("future done? " + future.isDone());
        List<String> result;
        try {
            result = future.get(); // It BLOCKS main thread until it returns!
            System.out.println("future done? " + future.isDone());
            System.out.println("Result: " + result); // Prints 20
        } catch (InterruptedException | ExecutionException ex) {
        }*/
   // }
}