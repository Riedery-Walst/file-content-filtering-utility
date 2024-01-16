package ru.andreev;

import org.apache.commons.cli.ParseException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            CommandLineOptions options = new CommandLineOptions(args);
            Statistics statistics = new Statistics(options.getCmd());
            StatisticsStrategy statisticsStrategy = new StatisticsStrategyImpl(statistics);
            FileManager fileManager = new FileManager(options.getOutputPath(), options.getPrefix(), options.isAppendMode());
            DataProcessor dataProcessor = new DataProcessor(options, fileManager, statisticsStrategy);
            dataProcessor.processFiles();
            statistics.printStatistics();
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}