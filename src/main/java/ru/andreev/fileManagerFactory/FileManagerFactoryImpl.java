package ru.andreev.fileManagerFactory;

import java.io.IOException;

public class FileManagerFactoryImpl implements FileManagerFactory {
    private final String outputPath;
    private final String prefix;
    private final boolean append;

    public FileManagerFactoryImpl(String outputPath, String prefix, boolean append) {
        this.outputPath = outputPath;
        this.prefix = prefix;
        this.append = append;
    }

    @Override
    public FileManager<Long> createIntegerFileManager() throws IOException {
        return new IntegerFileManager(outputPath, prefix + "integers.txt", append);
    }

    @Override
    public FileManager<Double> createFloatFileManager() throws IOException {
        return new FloatFileManager(outputPath, prefix + "floats.txt", append);
    }

    @Override
    public FileManager<String> createStringFileManager() throws IOException {
        return new StringFileManager(outputPath, prefix + "strings.txt", append);
    }
}