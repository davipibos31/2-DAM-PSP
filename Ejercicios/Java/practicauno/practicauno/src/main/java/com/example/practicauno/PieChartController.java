package com.example.practicauno;

import com.example.practicauno.model.Fight;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//CARGAMOS LAS FXML DEL SCREEN BUILDER
//TODO ESTO ES UNA PARTE ADICIONAL QUE ME SUBIRA NOTA (IMAGINO)
@SuppressWarnings("unused")
public class PieChartController {
    @FXML
    private AnchorPane anchorpane;

    @FXML
    private Button btnback;

    @FXML
    private PieChart piechart;

    @FXML
    private SplitPane splitpane;

    //INICIALIZAMOS EL FXML DEL PIECHART Y METEMOS LOS PARAMETROS PARA GESTIONAR EL PIECHART
    public void initialize() {
        // Get the controller object to get to the food list
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pie-chart.fxml"));
        //noinspection CatchMayIgnoreException
        try {
            //noinspection RedundantCast
            Parent root = (Parent) loader.load();
        } catch (Exception e) {}
        PieChartController controller = loader.getController();
        List<Fight> food = Fight.loadFlights();
        // Update the pie chart data from the food list data
        piechart.getData().clear();
        // We get a map with all the categories and the sum of its weights
        Map<String, List<Fight>> result;
        assert food != null;
        result = food.stream()
                .collect(Collectors.groupingBy(
                        Fight::getNumvul
                ));
        // We add an entry for the pie chart with each category and its sum
        result.forEach((cat, sum) -> piechart.getData().add(new PieChart.Data(cat, sum.size())));
    }
    //FUNCIÓN PARA VOLVER AL FXML ANTERIOR (PRINCIPAL) CARGAMOS EL FXML OPORTUNO
    @FXML
    void atras(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("hello-view.fxml"));
        Parent view1 = loader.load();
        Scene view1Scene = new Scene(view1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(view1Scene);
        stage.show();
    }
}
