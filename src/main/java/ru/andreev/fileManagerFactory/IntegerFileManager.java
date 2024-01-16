package ru.andreev.fileManagerFactory;

import java.io.*;

public class IntegerFileManager implements FileManager<Long> {
    private final PrintWriter integerWriter;

    public IntegerFileManager(String outputPath, String fileName, boolean append) throws IOException {
        this.integerWriter = createWriter(outputPath, fileName, append);
    }

    private PrintWriter createWriter(String outputPath, String fileName, boolean append) throws IOException {
        String fullPath = outputPath + File.separator + fileName;
        return new PrintWriter(new BufferedWriter(new FileWriter(fullPath, append)));
    }

    @Override
    public void addDataToFile(Long data) {
        integerWriter.println(data);
    }

    @Override
    public void close() {
        if (integerWriter != null) {
            integerWriter.close();
        }
    }
}