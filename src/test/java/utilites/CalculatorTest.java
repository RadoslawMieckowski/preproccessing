package utilites;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @BeforeEach
    void setup() {
        Calculator.setSMA_15_COUNTER(0);
        Calculator.setSMA_45_COUNTER(0);
        Calculator.setSMA_15_COUNTER(0);
    }

    @Test
    void calculateSimpleMovingAverage15Test() {
        double prices[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        double actualResult = 0;
        for(int i = 0; i <= 14; i++) {
            actualResult = Calculator.calculateSimpleMovingAverage15(prices[i]);
        }

        assertThat(actualResult).isEqualTo(7.000);
    }

    @Test
    void calculateSimpleMovingAverage15TestII() {
        double prices[] = {1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        double actualResult = 0;
        for(int i = 0; i <= 14; i++) {
            actualResult = Calculator.calculateSimpleMovingAverage15(prices[i]);
        }

        assertThat(actualResult).isEqualTo(7.067);
    }

    @Test
    void calculateSimpleMovingAverage15Called14TimesShouldReturn0Test() {
        double prices[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        double actualResult = 0;
        for(int i = 0; i <= 13; i++) {
            actualResult = Calculator.calculateSimpleMovingAverage15(prices[i]);
        }

        assertThat(actualResult).isEqualTo(0);
    }


    @Test
    void calculateSimpleMovingAverage15Called16TimesTest() {
        double prices[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 13};
        double actualResult = 0;
        for(int i = 0; i <= 15; i++) {
            actualResult = Calculator.calculateSimpleMovingAverage15(prices[i]);
        }

        assertThat(actualResult).isEqualTo(7.867);
    }

    @Test
    void calculateRSITest() {
        double prices[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        double actualResult = 0;
        for (int i = 0; i <= 13; i++) {
           actualResult =  Calculator.calculateRSI(prices[i]);
        }

        assertThat(actualResult).isEqualTo(100);
    }

    @Test
    void calculateRSITestII() {
        double prices[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 3};
        double actualResult = 0;
        for (int i = 0; i <= 13; i++) {
            actualResult =  Calculator.calculateRSI(prices[i]);
        }

        assertThat(actualResult).isEqualTo(57.143);
    }

    @Test
    void calculateRSICalled13TimesShouldReturn0Test() {
        double prices[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 3};
        double actualResult = 0;
        for (int i = 0; i <= 12; i++) {
            actualResult =  Calculator.calculateRSI(prices[i]);
        }

        assertThat(actualResult).isEqualTo(0);
    }

    @Test
    void calculateRSICalled15TimesTest() {
        double prices[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 3, 1};
        double actualResult = 0;
        for (int i = 0; i <= 14; i++) {
            actualResult =  Calculator.calculateRSI(prices[i]);
        }

        assertThat(actualResult).isEqualTo(50);
    }
}