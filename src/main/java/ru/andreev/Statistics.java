package ru.andreev;

import org.apache.commons.cli.CommandLine;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Statistics {
    private int longCounter;
    private int doubleCounter;
    private int stringCounter;
    private int minStringLength;
    private int maxStringLength;
    private long maxLong;
    private long minLong;
    private double minDouble;
    private double maxDouble;
    private BigInteger sumLong;
    private BigDecimal sumDouble;
    private BigInteger averageLong;
    private BigDecimal averageDouble;

    private final CommandLine cmd;

    public Statistics(CommandLine cmd) {
        this.cmd = cmd;
        this.sumLong = BigInteger.ZERO;  // Initialize longSum
        this.sumDouble = BigDecimal.ZERO;
    }

    public void printStatistics() {
        if (cmd.hasOption("s")) {
            System.out.println("Краткая статистика:");
            System.out.println("Целые числа: " + longCounter);
            System.out.println("Вещественные числа: " + doubleCounter);
            System.out.println("Строки: " + stringCounter);
        }

        if (cmd.hasOption("f")) {
            System.out.println("Полная статистика:");
            System.out.println("Целые числа: " + longCounter);
            System.out.println("Вещественные числа: " + doubleCounter);
            System.out.println("Строки: " + stringCounter);
            System.out.println("Наименьшее целое число: " + minLong);
            System.out.println("Наименьшее вещественное число: " + maxDouble);
            System.out.println("Минимальная длина строки: " + minStringLength);
            System.out.println("Максимальная длина строки: " + maxStringLength);
            System.out.println("Сумма целых чисел: " + sumLong);
            System.out.println("Сумма вещественных чисел: " + sumDouble);
            System.out.println("Срееднее целое число: " + averageLong);
            System.out.println("Среднее вещественное чисело: " + averageDouble);
        }
    }

    public void incrementLongCounter() {
        longCounter++;
    }

    public void incrementDoubleCounter() {
        doubleCounter++;
    }

    public void incrementStringCounter() {
        stringCounter++;
    }

    public void setMinStringLength(int length) {
        minStringLength = (minStringLength == 0 ) ? length : Math.min(minStringLength, length);
    }

    public void setMaxStringLength(int length) {
        maxStringLength = (maxStringLength == 0 ) ? length : Math.max(maxStringLength, length);
    }

    public int getLongCounter() {
        return longCounter;
    }

    public int getDoubleCounter() {
        return doubleCounter;
    }

    public void setMinLong(int num) {
        minLong = (minLong == 0 ) ? num : Math.min(minLong, num);
    }

    public void setMaxLong(int num) {
        maxLong = (maxLong == 0 ) ? num : Math.min(maxLong, num);
    }

    public void setMinDouble(double num) {
        minDouble = (minDouble == 0 ) ? num : Math.min(minDouble, num);
    }

    public void setMaxDouble(double num) {
        maxDouble = (maxDouble == 0 ) ? num : Math.min(maxDouble, num);
    }

    public void setSumOfLong(long num) {
        if (sumLong.add(BigInteger.valueOf(num)).compareTo(BigInteger.valueOf(Long.MAX_VALUE)) <= 0) {
            sumLong = sumLong.add(BigInteger.valueOf(num));
        } else {
            System.err.println("Произошло переполнение для longSum. Сумма не была добавлена.");
        }
    }

    public void setSumOfDouble(double num) {
        if (sumDouble.add(BigDecimal.valueOf(num)).compareTo(BigDecimal.valueOf(Double.MAX_VALUE)) <= 0) {
            sumDouble = sumDouble.add(BigDecimal.valueOf(num));
        } else {
            System.err.println("Произошло переполнение для doubleSum. Сумма не была добавлена.");
        }
    }
    public void setAverageLong(BigInteger longSum, int longCounter) {
        if (longCounter > 0) {
            averageLong = longSum.divide(BigInteger.valueOf(longCounter));
        } else {
            System.err.println("Не удалось вычислить averageLong. Число сброшено до нуля");
            averageLong = BigInteger.ZERO;
        }
    }

    public void setAverageDouble(BigDecimal doubleSum, int doubleCounter) {
        if (doubleCounter > 0) {
            averageDouble = doubleSum.divide(BigDecimal.valueOf(doubleCounter), RoundingMode.HALF_UP);
        } else {
            System.err.println("Не удалось вычислить averageLong. Число сброшено до нуля");
            averageDouble = BigDecimal.ZERO;
        }
    }

    public BigInteger getSumLong() {
        return sumLong;
    }

    public BigDecimal getSumDouble() {
        return sumDouble;
    }
}
