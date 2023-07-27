package com.example.demo.model;

import com.example.demo.model.person.Person;
import com.example.demo.model.person.PersonType;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class PersonFileDataSource implements IPersonDataSource{
    private String fileName = "";
public PersonFileDataSource(String fileName) {
    this.fileName = fileName;
}
    @Override
    public List<Person> getList() throws DataSourceException {
        try {
            return Files.lines(Paths.get(this.fileName))
                    .map(line -> new Person(
                            line.split(";")[0],
                            line.split(";")[1],
                            Integer.parseInt(line.split(";")[2]),
                            PersonType.valueOf(line.split(";")[3])
                    ))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new DataSourceException(e);
        }
    }

    @Override
    public void save(List<Person> list) throws DataSourceException {
        try (PrintWriter pw = new PrintWriter(this.fileName)) {

          //  list.stream().forEach(f -> pw.println(f.toString()));

            for (Person person : list) {
                pw.println(person.toString());
            }
        } catch (Exception e) {
            throw new DataSourceException(e);
        }
    }

    @Override
    public void delete(int position) throws DataSourceException {
        List<Person> l = this.getList();
        l.remove(position);
        this.save(l);
    }
}
