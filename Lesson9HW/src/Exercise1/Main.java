package Exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Integer[] array1 = new Integer[10];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = i + 1;
        }
        String[] array2 = new String[] {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        Double[] array3 = new Double[] {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0};
        Character[] array4 = new Character[] {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P'};

        printNewList(array1);
        printNewList(array2);
        printNewList(array3);
        printNewList(array4);
    }

    public static <T> void printNewList(T[] array) {
        List<T> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            list.add(array[i]);
        }
        list.remove(0);
        list.remove(0);
        list.remove(list.size() - 1);
        System.out.println(list);
    }
}