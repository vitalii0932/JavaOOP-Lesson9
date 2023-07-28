package Exercise3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextAnalyzer {

    public static void printFileTextAnalyze(File file) {
        String string = "";
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String temp;
            while((temp = br.readLine()) != null) {
                string += temp;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        string = string.toUpperCase();

        char[] stringChars = string.toCharArray();
        List<CharsCount> charsCountList = new ArrayList<>();
        for (char c : stringChars) {
            if(Character.isLetter(c)) {
                int i = listContainChar(charsCountList, c);
                if(i >= 0) {
                    charsCountList.get(i).setCount();
                } else {
                    charsCountList.add(new CharsCount(c));
                }
            }
        }

        Collections.sort(charsCountList);

        System.out.println("Result: \n" + charsCountList.toString());
    }

    private static int listContainChar(List<CharsCount> list, char c) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getC() == c) {
                return i;
            }
        }
        return -1;
    }
}
