package ru.andreev;

import ru.andreev.statisticStrategy.StatisticsStrategy;

import java.io.*;

public class DataProcessor {
    private final CommandLineOptions options;
    private final StatisticsStrategy statisticsStrategy;

    public DataProcessor(CommandLineOptions options, StatisticsStrategy statisticsStrategy) {
        this.options = options;
        this.statisticsStrategy = statisticsStrategy;
    }

    public void processLine(String line, BufferedWriter intWriter, BufferedWriter doubleWriter, BufferedWriter stringWriter) throws IOException {
        try {
            long longValue = Long.parseLong(line);
            statisticsStrategy.processLong(longValue);
            intWriter.write(line + System.lineSeparator());
        } catch (NumberFormatException e1) {
            try {
                double doubleValue = Double.parseDouble(line);
                statisticsStrategy.processDouble(doubleValue);
                doubleWriter.write(line + System.lineSeparator());
            } catch (NumberFormatException e2) {
                statisticsStrategy.processString(line);
                stringWriter.write(line + System.lineSeparator());
            }
        }
    }

    public void processFiles() throws IOException {
        File intFile = new File(options.getOutputPath() + options.getPrefix() + "integers.txt");
        File doubleFile = new File(options.getOutputPath() + options.getPrefix() + "floats.txt");
        File stringFile = new File(options.getOutputPath() + options.getPrefix() + "strings.txt");

        try (BufferedWriter intWriter = new BufferedWriter(new FileWriter(intFile, options.isAppendMode()));
             BufferedWriter doubleWriter = new BufferedWriter(new FileWriter(doubleFile, options.isAppendMode()));
             BufferedWriter stringWriter = new BufferedWriter(new FileWriter(stringFile, options.isAppendMode()))) {
            for (String inputFile : options.getInputFiles()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        processLine(line, intWriter, doubleWriter, stringWriter);
                    }
                }
            }
        }

        deleteIfEmpty(intFile);
        deleteIfEmpty(doubleFile);
        deleteIfEmpty(stringFile);
    }

    private void deleteIfEmpty(File file) {
        if (file.length() == 0) {
            if (file.delete()) {
                System.out.println("Удалены пустые файлы: " + file.getName());
            } else {
                System.err.println("Не удалось удалить пустые файлы" + file.getName());
            }
        }
    }

}
