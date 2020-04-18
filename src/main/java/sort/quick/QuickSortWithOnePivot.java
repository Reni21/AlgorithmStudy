package sort.quick;

import java.util.Arrays;

public class QuickSortWithOnePivot {
    public static void main(String[] args) {
        int[] arr = {-1234, 2, 89, -9, 0, 67, 67, 345};
        sort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    // Опорный эл-т - последний
    public static void sort2(int[] arr, int from, int to) { // index inclusive
        if (from >= to) {
            return;
        }

        int pivotIndex = to;
        int pivot = arr[pivotIndex]; // достаем и запоминаем опорный эл-т
        int i = from;
        while (i < pivotIndex) {
            if (arr[i] > pivot) {
                arr[pivotIndex] = arr[i]; // на место опорного ставим найденное большее значение
                if (pivotIndex - i != 1) { // если это не последний круг итерации где i-число, а i+1 опорный элемент
                    arr[i] = arr[pivotIndex - 1]; // перставляем значение, предшествующее опорному
                }
                pivotIndex--;
            } else {
                i++; // сдвигаем индекс только если перестроения не произошло
            }
        }
        arr[pivotIndex] = pivot; // в конце вставляем опорный эл-т по его финальному индексу
        sort2(arr, from, pivotIndex - 1);
        sort2(arr, pivotIndex + 1, to);
    }

    // Опорный эл-т - последний
    public static void sort3(int[] arr, int from, int to) {
        if (from >= to) {
            return;
        }

        int pivotIndex = to;
        int i = from;
            while (i < pivotIndex) {
        if (arr[i] > arr[pivotIndex]) {
            int buf = arr[pivotIndex]; // достаем опорный эл-т
            arr[pivotIndex] = arr[i]; // на место опорного ставим найденное большее значение

            // ищем место для вставки обратно опорного эл-та
            if (pivotIndex - i == 1) {
                arr[i] = buf;
            } else {
                arr[i] = arr[pivotIndex - 1];
                arr[pivotIndex - 1] = buf;
            }
            pivotIndex--;
        } else {
            i++; // сдвигаем индекс только если перестроения не произошло
        }
    }
    sort2(arr, from, pivotIndex - 1);
    sort2(arr, pivotIndex + 1, to);
    }


    // Опорный эл-т - в середине
    public static void sort(int[] arr, int from, int to) { // index inclusive
        if (from >= to) {
            return;
        }

        int pivotIndex = from + ((to - from) / 2);
        int left = from;
        int right = to;

        while (left <= right) {
            while (arr[left] < arr[pivotIndex]) { // находим число, большее чем опорный эл-т, кот стоит слева от опоры
                left++;
            }
            while (arr[right] > arr[pivotIndex]) { // находим число меньшее чем опорный эл-т, кот стоит справа от опоры
                right--;
            }

            if (left <= right) { // если индексы не персеклись, меняем найденные эл-ты местами
                int buf = arr[left];
                arr[left] = arr[right];
                arr[right] = buf;
                left++; // меняем индексы, сдвигая на изменившиеся значения
                right--;
            }
        }
        sort(arr, from, right);
        sort(arr, left, to);
    }


}
