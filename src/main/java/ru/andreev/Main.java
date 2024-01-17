package ru.andreev;

import org.apache.commons.cli.ParseException;
import ru.andreev.statisticStrategy.StatisticsStrategy;
import ru.andreev.statisticStrategy.StatisticsStrategyImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            CommandLineOptions options = new CommandLineOptions(args);
            Statistics statistics = new Statistics(options.getCmd());
            StatisticsStrategy statisticsStrategy = new StatisticsStrategyImpl(statistics);
            DataProcessor dataProcessor = new DataProcessor(options, statisticsStrategy);

            dataProcessor.processFiles();
            statistics.printStatistics();
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}

