/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.List;
import java.util.SortedMap;
import java.util.SortedSet;

/**
 *
 * @author RusTe
 */
public class Searcher {

    private SortedMap<Integer,Double> sort;  // тут хранится наш список длин от полученной точки
    private List<Double> listOfCellLat; // список Latitude (lat) всех точек
    private List<Double> listOfCellLon; // список Longtitude (long) всех точек
    private double cellLat; // lat нашей точки
    private double cellLon; // lon нашей точки

    public Searcher() {

        double length;
        for (int i = 0; i < listOfCellLat.size(); i++) { // т.к. у точки всегда 2 параметра - перебираем любую коллекцию
            //http://ru.onlinemschool.com/math/library/analytic_geometry/point_point_length/ - по этой формуле считаем расстояние до между точками
            length = Math.sqrt(Math.pow(cellLat - listOfCellLat.get(i), 2) + Math.pow(cellLon - listOfCellLon.get(i), 2));
            // и складываем его в сортированную мапу. где ключом будет i - номер в коллекции ( да по сути и id вышки)
            sort.put(i,length);
            
        }
        for (int i=0;i<5;i++)
        { // т.к. мапа сортированная ( ascending) - то тупо выводим первые 5 значений ключей - на длины нам класть.
            System.out.println(sort.values().toArray()[i]);
        }

    }

}
