package com.example.practicauno.utils;

import com.example.practicauno.model.Fight;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("ALL")
public class FileUtils {
    public final static File fichero  = new File("flight.txt");

    public static List<Fight> loadFlights() {

        try {
            return Files.lines(Paths.get("flight.txt"))
                    .map(line -> new Fight(line.split(";")[0],
                            line.split(";")[1],
                            LocalDateTime.parse(line.split(";")[2]),
                            LocalTime.parse(line.split(";")[3])))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void saveFlights(List<Fight>flightList){
        try (PrintWriter pw = new PrintWriter("flight.txt")) {
            flightList.forEach(f -> pw.println(f.toString()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}