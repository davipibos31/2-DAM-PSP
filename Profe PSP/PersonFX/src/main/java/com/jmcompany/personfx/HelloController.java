package com.jmcompany.personfx;

import com.jmcompany.personfx.model.DataSourceException;
import com.jmcompany.personfx.model.IPersonDataSource;
import com.jmcompany.personfx.model.PersonFileDataSource;
import com.jmcompany.personfx.model.person.Person;
import com.jmcompany.personfx.model.person.PersonType;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class HelloController {
    private List<Person> persons;
    private IPersonDataSource dataSource;
    @FXML
    private TableColumn<Person, Integer> ageColumn;

    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private TableColumn<Person, String> nameColumn;

    @FXML
    private TableView<Person> table;

    @FXML
    private TableColumn<Person, PersonType> typeColumn;

    public void initialize() {
        dataSource = new PersonFileDataSource("persons.txt");

        try {
            persons = dataSource.getList();

            nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
            lastNameColumn.setCellValueFactory(new PropertyValueFactory("lastName"));
            ageColumn.setCellValueFactory(new PropertyValueFactory("age"));
            typeColumn.setCellValueFactory(new PropertyValueFactory("type"));

            table.setItems(FXCollections.observableArrayList(persons));

        } catch (DataSourceException e) {
            throw new RuntimeException(e);
        }
    }

    public void onDelete() {
        Integer position = table.getSelectionModel().getSelectedIndex();
        table.getSelectionModel().getSelectedItem();
        try {
            dataSource.delete(position);
        } catch (DataSourceException e) {
            throw new RuntimeException(e);
        }
    }
}