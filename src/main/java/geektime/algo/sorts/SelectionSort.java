package geektime.algo.sorts;

public class SelectionSort {

    /*
    选择排序的核心思想是每次从未排序区选择一个最小/大的，放到已排序区的最后面。
     */
    public int[] selectionSort(int[] numbers){
        if(numbers.length <= 1){
            return  numbers;
        }

        for(int i = 0; i < numbers.length - 1; i++) {
            int  minIndex = i;                 // 未排序区的第一个元素作为最小/大的起始值
            for(int j = i + 1; j < numbers.length; j++) {
                if(numbers[j] < numbers[minIndex]){
                    minIndex = j;
                }
            }
            int temp = numbers[i];
            numbers[i] = numbers[minIndex];
            numbers[minIndex] = temp;      // 将找到的最小/大元素与未排序区的起始值进行交换
        }
        return numbers;
    }
}
