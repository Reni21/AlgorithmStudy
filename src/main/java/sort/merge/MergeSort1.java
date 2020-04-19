package sort.merge;


import java.util.Arrays;

public class MergeSort1 {
    public static void main(String[] args) {
        int[] arr4 = {2, 6, 2, 1, 4, 67, 3};
        sort(arr4);
        System.out.println("res: " + Arrays.toString(arr4));
    }

    private static void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int[] sorted = sort(arr, 0, arr.length - 1);
        System.arraycopy(sorted, 0, arr, 0, sorted.length);
    }

    private static int[] sort(int[] arr, int fromIndex, int toIndex) { // inclusive
        int middleIndex = fromIndex + ((toIndex - fromIndex) / 2);

        if (toIndex == fromIndex) { // если оба указателя указывают на одну ячейку - это равно массив из одного эл-та, возвращаем его
            return new int[]{arr[fromIndex]};
        }

        int[] left = sort(arr, fromIndex, middleIndex);
        int[] right = sort(arr, middleIndex + 1, toIndex);
        return merge(left, right);
    }

    // Собирает два отсортированных массива в один отсортированный
    private static int[] merge(int[] arr1, int[] arr2) {
        int[] mergeResult = new int[arr1.length + arr2.length];
        int index1 = 0;
        int index2 = 0;

        int indexRes = 0;
        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] < arr2[index2]) {
                mergeResult[indexRes++] = arr1[index1++];
            } else {
                mergeResult[indexRes++] = arr2[index2++];
            }
        }
        // добрасываем оставшиеся эл-ты в результирующий массив
        while (index1 < arr1.length) {
            mergeResult[indexRes++] = arr1[index1++];
        }
        while (index2 < arr2.length) {
            mergeResult[indexRes++] = arr2[index2++];
        }
        return mergeResult;
    }
}
