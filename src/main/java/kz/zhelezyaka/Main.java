package kz.zhelezyaka;

import java.io.*;
import java.util.*;

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

//            ---первая сортировка---

            // Сортировка по наименованию без учета регистра
//            Collections.sort(cityList, (city1, city2) ->
//                    city1.getName().compareToIgnoreCase(city2.getName()));
//            --------------------------------------------------------------

//              ---вторая сортировка---
            // Создаем компаратор для сортировки по федеральному округу и наименованию города
//            Comparator<City> cityComparator = Comparator
//                    .comparing(City::getDistrict)
//                    .thenComparing(City::getName);

            // Сортируем список городов
//            cityList.sort(cityComparator);
//            ----------------------------------------------------------------

//              ---поиск города с наибольшим количеством жителей---

            // Преобразуем список в массив
            City[] cityArray = cityList.toArray(new City[0]);

            int maxPopulation = 0;
            int maxPopulationIndex = -1;

            for (int i = 0; i < cityArray.length; i++) {
                if (cityArray[i].getPopulation() > maxPopulation) {
                    maxPopulation = cityArray[i].getPopulation();
                    maxPopulationIndex = i;
                }
            }

            if (maxPopulationIndex != -1) {
                System.out.println("[" + maxPopulationIndex + "] = " + maxPopulation);
            }

//            for (City city : cityList) {
//                System.out.println(city);
//            }
        } catch (FileNotFoundException e) {
            System.err.println("Такой файл не найден");
        }
    }
}