package Exercise3;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("text.txt");
        TextAnalyzer.printFileTextAnalyze(file);
    }
}
