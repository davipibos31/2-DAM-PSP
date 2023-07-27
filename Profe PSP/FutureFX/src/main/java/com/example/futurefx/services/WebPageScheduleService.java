package com.example.futurefx.services;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class WebPageScheduleService extends ScheduledService<Boolean> {

    private ThreadPoolExecutor executor;

    public WebPageScheduleService(ThreadPoolExecutor executor) {
        this.executor = executor;
    }

    @Override
    protected Task<Boolean> createTask() {
        return new Task<Boolean>() {
            @Override
            protected Boolean call() throws Exception {
                updateMessage("Completed: " + executor.getCompletedTaskCount());
                return executor.isTerminated();
            }
        };
    }
}
