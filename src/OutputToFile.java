import java.io.*;
import java.util.Scanner;

public class OutputToFile {
    private String fileName;

    public OutputToFile(String fileName) {
        this.fileName = fileName;
    }

    public void outputFile(String string) throws FileNotFoundException {
        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(fileName)), true));
        System.out.println(string);
    }

    public String getFileName() {
        return fileName;
    }

    private void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
