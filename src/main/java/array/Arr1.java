package array;

import java.util.HashSet;
import java.util.Set;

public class Arr1 {

    // Вернуть первое число из массива, которое повторяется.
    // Если повторяется несколько, то вернуть число, индекс второго повторения которого - наменьший
    // 1, 3, 5, 3, 5, 1, 5, 7, 9 - вернуть 3
    public int firstDuplicate(int[] arr) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : arr) {
            if(!set.add(num)) {
                return num;
            }
        }
        return -1;
    }

}
