package ru.andreev;

import org.apache.commons.cli.*;

import java.util.List;

public class CommandLineOptions {
    private final CommandLine cmd;
    private String outputPath;
    private String prefix;
    private boolean appendMode;
    private List<String> inputFiles;

    public CommandLineOptions(String[] args) throws ParseException {
        Options options = new Options();
        options.addOption("o", "output", true, "Путь для результатов");
        options.addOption("p", "prefix", true, "Префикс имен выходных файлов");
        options.addOption("a", "append", false, "Режим добавления в существующие файлы");
        options.addOption("s", "short", false, "Краткая статистика");
        options.addOption("f", "full", false, "Полная статистика");

        CommandLineParser parser = new DefaultParser();
        cmd = parser.parse(options, args);

        parseCommandLine();
    }

    private void parseCommandLine() {
        outputPath = cmd.getOptionValue("o", "./");
        prefix = cmd.getOptionValue("p", "");
        appendMode = cmd.hasOption("a");
        inputFiles = cmd.getArgList();

        if (inputFiles.isEmpty()) {
            throw new IllegalArgumentException("Не указаны входные файлы.");
        }
    }

    public CommandLine getCmd() {
        return cmd;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public String getPrefix() {
        return prefix;
    }

    public boolean isAppendMode() {
        return appendMode;
    }

    public List<String> getInputFiles() {
        return inputFiles;
    }
}
