package sort.merge;

import java.util.Arrays;

public class MergeSort2 {
    public static void main(String[] args) {
        int[] arr4 = {1,4,-1};
        mergesort(arr4, 0, arr4.length - 1);
        System.out.println("res: " + Arrays.toString(arr4));
    }

    private static void mergesort(int[] src, int fromIndex, int toIndex) {
        // разбиваем на подмассивы
        int mid = (fromIndex + toIndex) / 2;
        if (fromIndex < toIndex) {
            mergesort(src, fromIndex, mid);
            mergesort(src, mid + 1, toIndex);
        }

        // Берем из массива нужный отрезок, представляющий два подмассива > [from - mid] [mid - to] и перезаписываем его
        int index1 = fromIndex;
        int index2 = mid + 1;

        int[] merged = new int[toIndex - fromIndex + 1];
        int indexMerged = 0;

        while (index1 <= mid && index2 <= toIndex) {
            merged[indexMerged++] = src[index1] < src[index2] ? src[index1++] : src[index2++];
        }
        while (index1 <= mid) {
            merged[indexMerged++] = src[index1++];
        }
        while (index2 <= toIndex) {
            merged[indexMerged++] = src[index2++];
        }

        System.arraycopy(merged, 0, src, fromIndex, toIndex - fromIndex + 1);
    }
}