package com.example.demo;

import com.example.demo.model.DataSourceException;
import com.example.demo.model.IPersonDataSource;
import com.example.demo.model.PersonFileDataSource;
import com.example.demo.model.person.Person;
import com.example.demo.model.person.PersonType;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class HelloController {
    private List<Person> persons;
    private IPersonDataSource dataSource;

    @FXML
    private Button anyadir;
    @FXML
    private Button salir;

    @FXML
    private TableView tableview;

    @FXML
    private TableColumn<Person, String> nombret;
    @FXML
    private TableColumn<Person, String> apellidot;
    @FXML
    private TableColumn<Person, Integer> edadt;
    @FXML
    private TableColumn<Person, PersonType> tipot;

    public void initialize(){
        dataSource = new PersonFileDataSource("persons.txt");
        try {
           /* List<Person> persons = dataSource.getList();
           System.out.println(persons);

            persons.add(new Person("David","Piñuel", 23, PersonType.Trabajador));
            dataSource.save(persons);

            dataSource.delete(persons.size() - 1);
            */
            persons = dataSource.getList();
            nombret.setCellValueFactory(new PropertyValueFactory("name"));
            apellidot.setCellValueFactory(new PropertyValueFactory("lastName"));
            edadt.setCellValueFactory(new PropertyValueFactory("age"));
            tipot.setCellValueFactory(new PropertyValueFactory("type"));

            tableview.setItems(FXCollections.observableArrayList(persons));

        } catch (DataSourceException e) {
            throw new RuntimeException(e);
        }
    }

    public void onDelete() {
        Integer position = tableview.getSelectionModel().getSelectedIndex();
        tableview.getSelectionModel().getSelectedItems();
        try {
            dataSource.delete(position);
        } catch (DataSourceException e)
        {
            throw new RuntimeException(e);
        }
    }
}