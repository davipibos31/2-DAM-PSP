package com.example.demo.model;

import com.example.demo.model.person.Person;

import java.util.List;

public interface IPersonDataSource {

    List<Person> getList() throws DataSourceException;

    void save(List<Person> list) throws DataSourceException;

    void delete(int position) throws DataSourceException;

}
