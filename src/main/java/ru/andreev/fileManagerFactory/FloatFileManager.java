package ru.andreev.fileManagerFactory;

import java.io.*;

public class FloatFileManager implements FileManager<Double> {
    private final PrintWriter floatWriter;

    public FloatFileManager(String outputPath, String fileName, boolean append) throws IOException {
        this.floatWriter = createWriter(outputPath, fileName, append);
    }

    private PrintWriter createWriter(String outputPath, String fileName, boolean append) throws IOException {
        String fullPath = outputPath + File.separator + fileName;
        return new PrintWriter(new BufferedWriter(new FileWriter(fullPath, append)));
    }

    @Override
    public void addDataToFile(Double data) {
        floatWriter.println(data);
    }

    @Override
    public void close() {
        if (floatWriter != null) {
            floatWriter.close();
        }
    }
}