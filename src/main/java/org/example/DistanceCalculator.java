package org.example;
import java.util.Scanner;

public class DistanceCalculator {
    // Радиус Земли в километрах
    private static final double RADIUS_ZEMLI = 6371.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите координаты первой точки (широта и долгота в градусах):");
        double lat1 = scanner.nextDouble();
        double lon1 = scanner.nextDouble();

        System.out.println("Введите координаты второй точки (широта и долгота в градусах):");
        double lat2 = scanner.nextDouble();
        double lon2 = scanner.nextDouble();

        double distance = calculateDistance(lat1, lon1, lat2, lon2);
        System.out.println("Расстояние между точками: " + distance + " км");

        scanner.close();
    }

    // Метод для вычисления расстояния между двумя точками на поверхности Земли
    private static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Переводим координаты из градусов в радианы
        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        lat2 = Math.toRadians(lat2);
        lon2 = Math.toRadians(lon2);

        // Разницы между координатами
        double dlat = lat2 - lat1;
        double dlon = lon2 - lon1;

        // Вычисляем расстояние с использованием формулы гаверсинусов
        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = RADIUS_ZEMLI * c;

        return distance;
    }
}
