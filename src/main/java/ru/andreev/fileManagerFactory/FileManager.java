package ru.andreev.fileManagerFactory;

import java.io.IOException;

public interface FileManager<T> {
    void addDataToFile(T data) throws IOException;
    void close();
}