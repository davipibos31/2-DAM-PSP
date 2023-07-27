package com.example.demo;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

public class Food {
    String name;
    String category;
    int weight;
    public Food(String name, String category, int weight) {
        this.name = name;
        this.category = category;
        this.weight = weight;
    }
    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }
    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
    }
    @SuppressWarnings("unused")
    public String getCategory() {
        return category;
    }
    @SuppressWarnings("unused")
    public void setCategory(String category) {
        this.category = category;
    }
    @SuppressWarnings("unused")
    public int getWeight() {
        return weight;
    }
    @SuppressWarnings("unused")
    public void setWeight(int weight) {
        this.weight = weight;
    }
    @SuppressWarnings("unused")
    public String getWeightInOz() {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        return df.format((float) weight * 0.035274f);
    }

    @Override
    public String toString() {
        return name + ";" + category + ";" + weight;
    }

    static List<Food> readFile() {
        try {
            return Files.lines(Paths.get("food.txt"))
                    .map(line -> new Food(line.split(";")[0],
                            line.split(";")[1], Integer.parseInt(line.split(";")[2])))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    static void saveFile(List<Food> food) {
        try (PrintWriter pw = new PrintWriter("food.txt")) {
            food.stream().forEach(f -> pw.println(f.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}