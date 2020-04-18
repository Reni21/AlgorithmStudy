package sort.babble;

import java.util.Arrays;

public class BabbleSort {

    public static void main(String[] args) {
        int[] arr = {-7, 0, 9, 45};
        sortDesc(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortAsc(int[] arr) { // по возрастаню
        boolean isSwapped;

        for (int i = 0; i < arr.length; i++) {
            isSwapped = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int buf = arr[i];
                    arr[i] = arr[j];
                    arr[j] = buf;
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
    }

    public static void sortDesc(int[] arr) { // по убыванию
        boolean isSwapped;
        for (int i = 0; i < arr.length; i++) {
            isSwapped = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int buf = arr[i];
                    arr[i] = arr[j];
                    arr[j] = buf;
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }

    }
}
