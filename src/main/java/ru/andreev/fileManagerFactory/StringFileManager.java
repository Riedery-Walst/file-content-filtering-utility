package ru.andreev.fileManagerFactory;

import java.io.*;

public class StringFileManager implements FileManager<String> {
    private final PrintWriter stringWriter;

    public StringFileManager(String outputPath, String fileName, boolean append) throws IOException {
        this.stringWriter = createWriter(outputPath, fileName, append);
    }

    private PrintWriter createWriter(String outputPath, String fileName, boolean append) throws IOException {
        String fullPath = outputPath + File.separator + fileName;
        return new PrintWriter(new BufferedWriter(new FileWriter(fullPath, append)));
    }

    @Override
    public void addDataToFile(String data) {
        stringWriter.println(data);
    }

    @Override
    public void close() {
        if (stringWriter != null) {
            stringWriter.close();
        }
    }
}