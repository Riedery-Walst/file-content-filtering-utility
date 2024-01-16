package ru.andreev;

import org.apache.commons.cli.ParseException;
import ru.andreev.fileManagerFactory.FileManagerFactory;
import ru.andreev.fileManagerFactory.FileManagerFactoryImpl;
import ru.andreev.statisticStrategy.StatisticsStrategyImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            CommandLineOptions options = new CommandLineOptions(args);
            Statistics statistics = new Statistics(options.getCmd());

            FileManagerFactory fileManagerFactory = new FileManagerFactoryImpl(options.getOutputPath(), options.getPrefix(), options.isAppendMode());

            DataProcessor dataProcessor = new DataProcessor(options, fileManagerFactory, new StatisticsStrategyImpl(statistics));

            dataProcessor.processFiles();

            statistics.printStatistics();
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}
