package com.example.practica2;


import com.example.practica2.model.WebPage;
import com.example.practica2.utils.FileUtils;
import com.example.practica2.utils.LinkReader;
import com.example.practica2.utils.MessageUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javax.swing.JOptionPane;

import java.io.*;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class HelloController extends Window{
    //CARGAMOS LOS FXML DEL SCREENBUILDER
    @FXML
    private BorderPane BorderPane1;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    private Label label5;

    @FXML
    private Label label6;

    @SuppressWarnings("rawtypes")
    @FXML
    private ListView Listview1;

    @SuppressWarnings("rawtypes")
    @FXML
    private ListView Listview2;

    @FXML
    private MenuBar MenuBar1;

    @FXML
    private Menu Menu1;

    @FXML
    private Menu Menu2;

    @FXML
    private MenuItem MenuItem1;

    @FXML
    private MenuItem MenuItem2;

    @FXML
    private MenuItem MenuItem11;

    @FXML
    private MenuItem MenuItem21;

    //ESTA FUNCIÓN ES AL PULSAR EN EL MENU EL BOTON EXIT, SALE DE LA APLICACIÓN.
    @FXML
    void exit1(ActionEvent event) throws Throwable {
        try {
            System.exit(0);
        }catch (Exception e)
        {
            throw new MessageUtils(e);
        }
    }

    public static ObservableList<String> parte2l;
    public static String part2;
    @SuppressWarnings("ClassEscapesDefinedScope")
    public static WebPage p;

    //ESTA FUNCIÓN CARGA EL FICHERO POR FILECHOOSER Y LEE EL FICHERO CARGANDO EN UNAS LISTAS Y EN LA TABLA LOS NOMBRES Y LAS URLS
    @FXML
    void load1(ActionEvent event) throws Throwable{
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Buscar fichero txt");

            // Agregar filtros para facilitar la busqueda
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("All FILES", "*.*"),
                    new FileChooser.ExtensionFilter("TXT", "*.txt"),
                    new FileChooser.ExtensionFilter("DOC", "*.doc")
            );

            // Obtener la imagen seleccionada
            File Filetxt = fileChooser.showOpenDialog(this);
            String tp = "";
            // Mostar la imagen
            if (Filetxt != null) {

                File f1 = new File(Filetxt.getAbsolutePath());
                // Path path = (Path) Filetxt.toPath();

                String cadena;
                FileReader f = new FileReader(f1);
                BufferedReader b = new BufferedReader(f);
                //noinspection unused
                LinkReader linkReader = new LinkReader(b);
                while((cadena = b.readLine())!=null) {
                    String[] parts = cadena.split(";");
                    String part1 = parts[0];
                    part2 = parts[1];
                    //noinspection unused
                    ObservableList<String> parte1 = FXCollections.observableArrayList(part1);
                    parte2l = FXCollections.observableArrayList(part2);
                    p = new WebPage(part1, part2);
                    //noinspection ResultOfMethodCallIgnored
                    p.getList();
                    //noinspection unchecked
                    Listview1.getItems().add(p.getNombre());
                    // Listview2.getItems().add(parte2);
                    System.out.println(cadena);
                    tp = String.valueOf((long) Listview1.getItems().size());
                    label2.setText(tp);
                }
                b.close();
                JOptionPane.showMessageDialog(null, "Se ha cargado un total de  " + tp + " páginas.");
                //noinspection ResultOfMethodCallIgnored
                FileUtils.loadPages(f1.getAbsolutePath());
            }
        } catch (Exception e) {
            throw new MessageUtils(e);
        }
    }
    //ESTA FUNCIÓN QUITA LO QUE HAYA EN LAS DOS TABLAS
    @FXML
    void clear1(ActionEvent event) throws Throwable{
        try {
            if((long) Listview1.getItems().size() != 0) Listview1.getItems().clear();
            else JOptionPane.showMessageDialog(null, "Error al limpiar, ya esta vacia la lista 1.");
            if((long) Listview2.getItems().size() != 0) Listview2.getItems().clear();
            else JOptionPane.showMessageDialog(null, "Error al limpiar, ya esta vacia la lista 2.");
        } catch (Exception e) {
            throw new MessageUtils(e);
        }
    }
    String tp = "";
    List<String> l;
    //EN ESTA FUNCIÓN CREAMOS LOS HILOS Y LOS AGRUPAMOS EN EL EXECUTOR, MOSTRAMOS LAS PAGINAS BUSCADAS Y CONTAMOS LOS LINKS, Y LOS HILOS COMPLETOS.
    @FXML
    void start1(ActionEvent event) throws Throwable {
        ThreadPoolExecutor threadPoolExecutor;
        try {
            threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Listview1.getItems().size());

            threadPoolExecutor.execute(() -> {
                l = LinkReader.getLinks(p.getUrl());
                for (int i = 0; i < (long) l.size(); i++) {
                    //noinspection unchecked
                    Listview2.getItems().add(l.get(i));
                }
                tp = String.valueOf((long) Listview2.getItems().size());
                JOptionPane.showMessageDialog(null, "Se ha cargado un total de " + tp + " links.");
                JOptionPane.showMessageDialog(null, "Hay un máximo de " + threadPoolExecutor.getMaximumPoolSize() + " hilos cargados.");
            });
            String tp2 = String.valueOf(threadPoolExecutor.getTaskCount());
            JOptionPane.showMessageDialog(null, "Total hilos " + tp2 + " ejecutandose.");
            label6.setText(String.valueOf((long) l.size()));
        } catch (Exception e) {
            throw new MessageUtils(e);
        }
        String tp3 = String.valueOf(threadPoolExecutor.getCompletedTaskCount()); // este sería el completado
        JOptionPane.showMessageDialog(null, "Total de " + tp3 + " hilos completados.");
        label4.setText(tp3);
    }
}