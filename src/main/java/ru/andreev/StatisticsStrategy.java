package ru.andreev;

public interface StatisticsStrategy {
    void processLong(long longValue);
    void processDouble(double doubleValue);
    void processString(String stringValue);

}
