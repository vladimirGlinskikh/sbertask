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
//            -----------------------------3 часть-----------------------------
//            Полученный список объектов City нужно вывести в консоль

//            for (City city : cityList) {
//                System.out.println(city);
//            }
//            -------------------------------5 часть----------------------------
//            ---Сортировка списка городов по наименованию в алфавитном порядке
//            по убыванию без учета регистра---

//            Collections.sort(cityList, (city1, city2) ->
//                    city1.getName().compareToIgnoreCase(city2.getName()));

//            --------------------------------------------------------------
//              ---Сортировка списка городов по федеральному округу и наименованию
//              города внутри каждого федерального округа в алфавитном порядке по
//              убыванию с учетом регистра---

//            Comparator<City> cityComparator = Comparator
//                    .comparing(City::getDistrict)
//                    .thenComparing(City::getName);

//            cityList.sort(cityComparator);

//            ---------------------------------7 часть-------------------------------
//              ---поиск города с наибольшим количеством жителей---

//            City[] cityArray = cityList.toArray(new City[0]);
//
//            int maxPopulation = 0;
//            int maxPopulationIndex = -1;
//
//            for (int i = 0; i < cityArray.length; i++) {
//                if (cityArray[i].getPopulation() > maxPopulation) {
//                    maxPopulation = cityArray[i].getPopulation();
//                    maxPopulationIndex = i;
//                }
//            }
//
//            if (maxPopulationIndex != -1) {
//                System.out.println("[" + maxPopulationIndex + "] = " + maxPopulation);
//            }
//            ----------------------------------9 часть---------------------------------

//            ---Определяем количество городов в каждом регионе---

//            Map<String, Integer> regionCityCountMap = new HashMap<>();
//
//            for (City city : cityList) {
//                String region = city.getRegion();
//                regionCityCountMap.put(region, regionCityCountMap.getOrDefault(region, 0) + 1);
//            }
//
//            for (Map.Entry<String, Integer> entry : regionCityCountMap.entrySet()) {
//                System.out.println(entry.getKey() + " - " + entry.getValue());
//            }

//            ------------------------------------------------------------
        } catch (FileNotFoundException e) {
            System.err.println("Такой файл не найден");
        }
    }
}