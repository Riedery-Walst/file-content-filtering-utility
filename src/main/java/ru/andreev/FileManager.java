package ru.andreev;

import java.io.*;

public class FileManager {
    private final PrintWriter integerWriter;
    private final PrintWriter floatWriter;
    private final PrintWriter stringWriter;

    public FileManager(String outputPath, String prefix, boolean append) throws IOException {
        this.integerWriter = createWriter(outputPath, prefix + "integers.txt", append);
        this.floatWriter = createWriter(outputPath, prefix + "floats.txt", append);
        this.stringWriter = createWriter(outputPath, prefix + "strings.txt", append);
    }

    private PrintWriter createWriter(String outputPath, String fileName, boolean append) throws IOException {
        String fullPath = outputPath + File.separator + fileName;
        return new PrintWriter(new BufferedWriter(new FileWriter(fullPath, append)));
    }

    public void addLongToFile(long intLine) {
        integerWriter.println(intLine);
    }

    public void addDoublesToFile(double doubleLine) {
        floatWriter.println(doubleLine);
    }

    public void addStringsToFile(String strLine) {
        stringWriter.println(strLine);
    }

    public void close() {
        if (integerWriter != null) {
            integerWriter.close();
        }
        if (floatWriter != null) {
            floatWriter.close();
        }
        if (stringWriter != null) {
            stringWriter.close();
        }
    }

}
