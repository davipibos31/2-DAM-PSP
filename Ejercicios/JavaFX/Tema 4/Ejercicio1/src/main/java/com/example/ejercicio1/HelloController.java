package com.example.ejercicio1;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.util.Duration;

public class HelloController {
   @FXML
    private FlowPane FlowPane1;

    public HelloController(FlowPane flowPane1, Label label1, TranslateTransition t) {
        FlowPane1 = flowPane1;
        this.label1 = label1;
        this.t = t;
        t = new TranslateTransition(Duration.millis(3000), this.label1);
    }
    @FXML
    private Label label1;
    @FXML
            private TranslateTransition t;
    t.setFromX();
        t.setFromY(0);
        t.setToX(300);
        t.setToY(0);
        t.play();


    public void initialize() {
    }
}