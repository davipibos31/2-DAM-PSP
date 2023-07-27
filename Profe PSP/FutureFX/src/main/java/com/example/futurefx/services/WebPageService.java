package com.example.futurefx.services;

import com.example.futurefx.model.WebPage;
import com.example.futurefx.utils.LinkReader;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class WebPageService extends Service<List<WebPage>> {

    private ThreadPoolExecutor executor;

    public WebPageService(ThreadPoolExecutor executor) {
        this.executor = executor;
    }

    public static Callable<WebPage> completeWebPage(WebPage wp) {
        return () -> {
            wp.setLinks(LinkReader.getLinks(wp.getUrl()));
            return wp;
        };
    }

    @Override
    protected Task<List<WebPage>> createTask() {
        return new Task<List<WebPage>>() {
            @Override
            protected List<WebPage> call() throws Exception {
                // 1- obtener listado webpage
                List<WebPage> list = Arrays.asList(
                        new WebPage("futbol", "https://aa.futbol.nu"),
                        new WebPage("marca", "https://marca.com"),
                        new WebPage("marca", "https://marca.com"),
                        new WebPage("koora", "https://www.koora.live"),
                        new WebPage("elpais", "https://www.elpais.com")
                );

                List<Future<WebPage>> futures = new ArrayList<>();
                // 2 - Recorrer webpage call
                for (WebPage wp : list) {
                    // 3 - Obtener el future
                    Future<WebPage> future = executor.submit(completeWebPage(wp));
                    futures.add(future);
                }
                executor.shutdown();
                // 4 - obtener el resultado del future
                List<WebPage> result = new ArrayList<>();
                Integer totalLinks = 0;
                for (Future<WebPage> future : futures) {
                    WebPage wp = future.get();
                    totalLinks += wp.getLinks().size();
                    updateMessage("Total: " + totalLinks);

                    // 5 -devolver listado rellenado de webpage
                    result.add(wp);
                }

                return result;
            }
        };


    }
}
