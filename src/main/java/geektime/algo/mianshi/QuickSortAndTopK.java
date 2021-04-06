package geektime.algo.mianshi;

import java.util.Arrays;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-23 11:37
 * @description: 使用快速排序方法来选取topK问题
 */
public class QuickSortAndTopK {

    public static void main(String[] args) {
        int[] numbers = {2,3,3,8,3,4,7,3};

        int[] sorted = getLowestTopK(numbers, 7);
        for (int i = 0; i < sorted.length; i++) {
           System.out.print(numbers[i]);
        }
    }

    private static int[] quickSort(int[] numbers) {
       if (numbers.length <=1) {
           return numbers;
       }
       quickSortInternal(numbers, 0, numbers.length -1);
       return numbers;
    }

    public static int[] getLowestTopK(int[] numbers, int k) {
        if (k >= numbers.length) {
            return numbers;
        }
        int index = getLowestTopKInternal(numbers, 0, numbers.length - 1, k);
        System.out.println(index);

        return Arrays.copyOfRange(numbers, 0, index);

    }

    public static int getLowestTopKInternal(int[] numbers, int low, int high, int k) {

        int provitIndex = partition(numbers, low, high);
        if (provitIndex == k) {
            return provitIndex;
        }
        if (provitIndex < k) {
            return  getLowestTopKInternal(numbers, provitIndex+1, high, k);
        }
        return getLowestTopKInternal(numbers, low, provitIndex-1, k);
    }

    private static void quickSortInternal(int[] numbers, int low, int high) {
        if (low>=high) {
            return;
        }
        int provitIndex = partition(numbers, low, high);
        quickSortInternal(numbers, low, provitIndex-1);
        quickSortInternal(numbers, provitIndex+1, high);
    }

    private static int partition(int[] numbers, int low, int high) {
        int provit = numbers[high];
        int provitIndex = low;
        for (int index = low; index < high; index++) {
            if (numbers[index] < provit) {
                if (index == provitIndex) {
                    provitIndex++;
                } else {
                    int temp = numbers[index];
                    numbers[index] = numbers[provitIndex];
                    numbers[provitIndex++] = temp;
                }
            }
        }
        int temp = numbers[provitIndex];
        numbers[provitIndex] = numbers[high];
        numbers[high] = temp;

        System.out.println(provitIndex);
        return provitIndex;
    }


}
