package ru.andreev;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataProcessor {
    private final CommandLineOptions options;
    private final FileManager fileManager;
    private final StatisticsStrategy statisticsStrategy;

    public DataProcessor(CommandLineOptions options, FileManager fileManager, StatisticsStrategy statisticsStrategy) {
        this.options = options;
        this.fileManager = fileManager;
        this.statisticsStrategy = statisticsStrategy;
    }

    public void processFiles() throws IOException {
        for (String inputFile : options.getInputFiles()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    processLine(line);
                }
            }
        }
        fileManager.close();
    }

    public void processLine(String line) {
        try {
            long longValue = Long.parseLong(line);

            fileManager.addLongToFile(longValue);

            statisticsStrategy.processLong(longValue);
        } catch (NumberFormatException e1) {
            try {
                double doubleValue = Double.parseDouble(line);

                fileManager.addDoublesToFile(doubleValue);

                statisticsStrategy.processDouble(doubleValue);
            } catch (NumberFormatException e2) {
                fileManager.addStringsToFile(line);

                statisticsStrategy.processString(line);
            }
        }
    }
}
