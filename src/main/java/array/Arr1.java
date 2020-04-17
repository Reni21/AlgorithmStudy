package array;

import java.util.*;
import java.util.stream.Collectors;

public class Arr1 {

    // Вернуть первое число из массива, которое повторяется.
    // Если повторяется несколько, то вернуть число, индекс второго повторения которого - наменьший
    // 1, 3, 5, 3, 5, 1, 5, 7, 9 - вернуть 3
    public int firstDuplicate(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }

    // В массиве положительных чисел найти наименьшее отсутствующее число
    // O(n + n log n) Изменяет текущий массив, константная доп память, массив может сожержать повторения
    public int gettingTheDifferentNumber(int[] arr) {
        if (arr == null || arr.length == 0) {
            return Integer.MIN_VALUE;
        }

        Arrays.sort(arr);
        int prev = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - prev > 1) {
                return prev + 1;
            }
            prev = arr[i];
        }
        return prev + 1;
    }

    // O(N), использует доп память, массив может содержать повторения, не изменяет текущий массив
    public int gettingTheDifferentNumber2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return Integer.MIN_VALUE;
        }

        Map<Integer, Boolean> map = new HashMap<>();
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            map.put(i, true);
        }

        for (int i = min; i < Integer.MAX_VALUE; i++) {
            if (map.get(i) == null) {
                return i;
            }
        }
        if (map.get(Integer.MAX_VALUE)) {
            throw new RuntimeException("Result value beyond the bound");
        }
        return Integer.MAX_VALUE;
    }

    // Для массива не содержащего повторений и при запрете изменения исходного
    public long gettingTheDifferentNumber3(int[] arr) {
        if (arr == null || arr.length == 0) {
            return Integer.MIN_VALUE;
        }

        List<Integer> list = Arrays.stream(arr)
                .boxed() // wrap int into Integer
                .sorted()
                .collect(Collectors.toList());

        long num = (long) list.get(0) + 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) != num++) {
                return --num;
            }
        }
        return num;
    }

}
