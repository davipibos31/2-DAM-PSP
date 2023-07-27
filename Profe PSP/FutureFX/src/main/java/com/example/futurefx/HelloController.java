package com.example.futurefx;

import com.example.futurefx.model.WebPage;
import com.example.futurefx.services.WebPageScheduleService;
import com.example.futurefx.services.WebPageService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class HelloController {
    private WebPageService service;
    private WebPageScheduleService scheduleService;

    @FXML
    private Label welcomeText;

    @FXML
    private Label processedText;

    @FXML
    protected void onHelloButtonClick() {
        service.reset();
        service.start();

        scheduleService.reset();
        scheduleService.start();
    }

    public void initialize(){
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors());

        service = new WebPageService(executor);
        scheduleService = new WebPageScheduleService(executor);

        service.setOnSucceeded(e -> {
            List<WebPage> l = service.getValue();
            System.out.println(l);
           // service.reset();
        });
        service.setOnCancelled(e -> {
            service.reset();
        });
        service.setOnFailed(e -> {
           service.reset();
        });


        scheduleService.setOnSucceeded(s->{
            if (scheduleService.getValue()){
                scheduleService.cancel();
                service.cancel();
            }
            processedText.setText(scheduleService.getMessage());
            welcomeText.setText(service.getMessage());
        });
        scheduleService.setPeriod(Duration.millis(100));
       // processedText.textProperty().bind(scheduleService.messageProperty());
    }
}