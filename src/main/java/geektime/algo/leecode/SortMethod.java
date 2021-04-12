package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-22 23:29
 * @description:
 */
public class SortMethod {

    // 快速排序
    public static int[] quickSort(int[] numbers) {
        quickSortInternal(numbers, 0, numbers.length);

        return numbers;
    }

    private static void quickSortInternal(int[] numbers, int low, int high) {
        int index = partition(numbers, low, high);
        quickSortInternal(numbers, low, index - 1);
        quickSortInternal(numbers, index + 1, high);

    }

    private static int partition(int[] numbers, int low, int high) {
        int pviot = numbers[high];

        return 0;
    }

    // 插入排序
    public static int[] insertSort(int[] numbers) {
        return numbers;

    }


    // 选择排序
    public static int[]  selectionSort(int[] numbers) {
        return numbers;

    }

    // 归并排序
    public static int[] mergeSort(int[] numbers) {
        return numbers;
    }
}