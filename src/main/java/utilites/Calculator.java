package utilites;

import java.util.ArrayList;
import java.util.List;

public final class Calculator {
    private static double SMA_15_COUNTER = 1;
    private static double SMA_45_COUNTER = 1;
    private static double RSI_COUNTER = 1;
    private static List<Double> SMA_15_STORAGE = new ArrayList<>(15);
    private static List<Double> SMA_45_STORAGE = new ArrayList<>(45);
    private static List<Double> RSI_14_STORAGE = new ArrayList<>(14);

    private Calculator() {

    }

    public static double calculateRSI(int days) {
        return 0;
    }

    public static double calculateSimpleMovingAverage15(double closePrice) {
        SMA_15_COUNTER++;
        double result = 0;
        //atualizowanie ostatnich 15-stu cen potrzebnych do wyliczenia średniej
        if (SMA_15_STORAGE.size() == 15) {
            SMA_15_STORAGE.remove(0);
        }
        SMA_15_STORAGE.add(closePrice);
        //obliczanie SMA15, jeżeli licznik jest równy przynajmniej 15
        if (SMA_15_COUNTER >= 15) {
            result =  SMA_15_STORAGE.stream().reduce(result, Double::sum);
            result = result / 15;
        }
        return result;
    }

    public static double calculateSimpleMovingAverage45(double closePrice) {
        SMA_45_COUNTER++;
        double result = 0;
        //atualizowanie ostatnich 15-stu cen potrzebnych do wyliczenia średniej
        if (SMA_45_STORAGE.size() == 45) {
            SMA_45_STORAGE.remove(0);
        }
        SMA_45_STORAGE.add(closePrice);
        //obliczanie SMA15, jeżeli licznik jest równy przynajmniej 15
        if (SMA_45_COUNTER >= 45) {
            result =  SMA_45_STORAGE.stream().reduce(result, Double::sum);
            result = result / 45;
        }
        return result;
    }
}
