package com.ricardo_nacher.utils;

import com.ricardo_nacher.model.Flight;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtils  {
 final static   File fichero  = new File("C:\\Users\\Richy\\IdeaProjects\\FlightsFX.flight.txt");

    public static List<Flight>loadFlights() {

        try {
            return Files.lines(Paths.get("flight.txt"))
                    .map(line -> new Flight(line.split(";")[0],
                            line.split(";")[1],
                            LocalDateTime.parse(line.split(";")[2]),
                            LocalTime.parse(line.split(";")[3])))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }



    }
   public static void saveFlights(List<Flight>flightList){
       try (PrintWriter pw = new PrintWriter("flight.txt")) {
           flightList.stream().forEach(f -> pw.println(f.toString()));

       } catch (Exception e) {
           e.printStackTrace();
       }
    }
}
