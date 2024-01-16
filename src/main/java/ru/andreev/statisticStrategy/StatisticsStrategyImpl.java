package ru.andreev.statisticStrategy;

import ru.andreev.Statistics;

public class StatisticsStrategyImpl implements StatisticsStrategy {
    private final Statistics statistics;

    public StatisticsStrategyImpl(Statistics statistics) {
        this.statistics = statistics;
    }

    @Override
    public void processLong(long longValue) {
        statistics.incrementLongCounter();
        statistics.setMinLong((int) longValue);
        statistics.setMaxLong((int) longValue);
        statistics.setSumOfLong(longValue);
        statistics.setAverageLong(statistics.getSumLong(), statistics.getLongCounter());
    }

    @Override
    public void processDouble(double doubleValue) {
        statistics.incrementDoubleCounter();
        statistics.setMinDouble(doubleValue);
        statistics.setMaxDouble(doubleValue);
        statistics.setSumOfDouble(doubleValue);
        statistics.setAverageDouble(statistics.getSumDouble(), statistics.getDoubleCounter());
    }

    @Override
    public void processString(String stringValue) {
        statistics.incrementStringCounter();
        statistics.setMaxStringLength(stringValue.length());
        statistics.setMinStringLength(stringValue.length());
    }
}

