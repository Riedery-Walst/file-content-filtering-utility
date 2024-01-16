package ru.andreev.fileManagerFactory;

import java.io.IOException;

public interface FileManagerFactory {
    FileManager<Long> createIntegerFileManager() throws IOException;
    FileManager<Double> createFloatFileManager() throws IOException;
    FileManager<String> createStringFileManager() throws IOException;
}