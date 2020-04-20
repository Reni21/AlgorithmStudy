package string;

import java.util.*;

// Найти все возможные комбинации для букв в строке
public class String1 {
    public static void main(String[] args) {
        String str = "ABC";
        //printCombination(str, 0);
        Set<String> combinations = new TreeSet<>();
        collectAllPossibleCombination(str, 0, combinations);
        combinations.forEach(System.out::println);
    }

    public static void printCombination(String str, int from) {
        int lastIndex = str.length() - 1;
        if (lastIndex == from) {
            System.out.println(str);
            return;
        }
        for (int i = from; i < str.length(); i++) {
            str = shiftLetters(str, from);
            printCombination(str, from + 1); // фиксируем часть строки
        }
    }

    // for shiftFrom=1 ABC > ACB
    private static String shiftLetters(String str, int shiftFrom) {
        int lastIndex = str.length() - 1;
        String start = str.substring(0, shiftFrom);
        char middle = str.charAt(lastIndex);
        String tail = str.substring(shiftFrom, lastIndex);
        return start + middle + tail;
    }

    public static void collectAllPossibleCombination(String str, int from, Set<String> combinations) {
        int lastIndex = str.length() - 1;
        if (lastIndex == from) {
            combinations.add(str);
            return;
        }
        for (int i = from; i < str.length(); i++) {
            str = shiftLetters(str, from);
            collectAllPossibleCombination(str, from + 1, combinations);
        }
    }

}
