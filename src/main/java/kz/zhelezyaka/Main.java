package kz.zhelezyaka;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<City> cityList = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("src/main/resources/Задача ВС Java Сбер.csv"));
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");
                if (parts.length == 6) {
                    String name = parts[1];
                    String region = parts[2];
                    String district = parts[3];
                    int population = Integer.parseInt(parts[4]);
                    String foundation = parts[5];
                    City city = new City(
                            name,
                            region,
                            district,
                            population,
                            foundation);
                    cityList.add(city);
                }
            }
            scanner.close();

            for (City city : cityList) {
                System.out.println(city);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Такой файл не найден");
        }
    }
}