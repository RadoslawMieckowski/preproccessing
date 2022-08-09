package utilites;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Calculator {
    private static double SMA_15_COUNTER = 0;
    private static double SMA_45_COUNTER = 0;
    private static double RSI_COUNTER = 0;
    private static List<Double> SMA_15_STORAGE = new ArrayList<>(15);
    private static List<Double> SMA_45_STORAGE = new ArrayList<>(45);
    private static List<Double> RSI_14_STORAGE = new ArrayList<>(14);

    private Calculator() {

    }

    public static double calculateRSI(double closePrice) {
        RSI_COUNTER++;
        double differences[] = new double[13];
        double negativeSum;
        double positiveSum;
        double result = 0;
        //atualizowanie ostatnich 14-stu cen potrzebnych do wyliczenia średniej
        if (RSI_14_STORAGE.size() == 14) {
            RSI_14_STORAGE.remove(0);
        }
        RSI_14_STORAGE.add(closePrice);
        //obliczanie RSI, jeżeli licznik jest równy przynajmniej 14
        if (RSI_COUNTER >= 14) {
            for (int i = 0; i < 13; i++) {
                differences[i] = RSI_14_STORAGE.get(i + 1) - RSI_14_STORAGE.get(i);
                positiveSum = Arrays.stream(differences).filter(change -> change > 0).sum();
                negativeSum = Arrays.stream(differences).filter(change -> change < 0).sum();
                negativeSum = Math.abs(negativeSum);
                result = 100 - (100 / (1 + positiveSum / negativeSum));
            }
        }
        return result;
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
        //atualizowanie ostatnich 45-stu cen potrzebnych do wyliczenia średniej
        if (SMA_45_STORAGE.size() == 45) {
            SMA_45_STORAGE.remove(0);
        }
        SMA_45_STORAGE.add(closePrice);
        //obliczanie SMA45, jeżeli licznik jest równy przynajmniej 45
        if (SMA_45_COUNTER >= 45) {
            result =  SMA_45_STORAGE.stream().reduce(result, Double::sum);
            result = result / 45;
        }
        return result;
    }
}
