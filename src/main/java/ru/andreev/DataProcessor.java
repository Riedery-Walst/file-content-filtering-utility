package ru.andreev;

import ru.andreev.fileManagerFactory.FileManager;
import ru.andreev.fileManagerFactory.FileManagerFactory;
import ru.andreev.statisticStrategy.StatisticsStrategy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataProcessor {
    private final CommandLineOptions options;
    private final FileManagerFactory fileManagerFactory;
    private final StatisticsStrategy statisticsStrategy;

    public DataProcessor(CommandLineOptions options, FileManagerFactory fileManagerFactory,
                         StatisticsStrategy statisticsStrategy) {
        this.options = options;
        this.fileManagerFactory = fileManagerFactory;
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
    }

    public void processLine(String line) throws IOException {
        try {
            long longValue = Long.parseLong(line);

            FileManager<Long> integerFileManager = fileManagerFactory.createIntegerFileManager();
            integerFileManager.addDataToFile(longValue);

            statisticsStrategy.processLong(longValue);
            integerFileManager.close();
        } catch (NumberFormatException e1) {
            try {
                double doubleValue = Double.parseDouble(line);

                FileManager<Double> floatFileManager = fileManagerFactory.createFloatFileManager();
                floatFileManager.addDataToFile(doubleValue);

                statisticsStrategy.processDouble(doubleValue);
                floatFileManager.close();
            } catch (NumberFormatException | IOException e2) {
                FileManager<String> stringFileManager = fileManagerFactory.createStringFileManager();
                stringFileManager.addDataToFile(line);

                statisticsStrategy.processString(line);
                stringFileManager.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}