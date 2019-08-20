package geektime.algo.sorts;

public class QuickSort {
    /*
    快速排序的思想是从p 到r 之间任意取一个数据作为区分点（pivot）， 遍历p～r之间的数据，
    大于pivot的放在其右边，小于的放在其左边。
    重点在如何查找这个区分点的下标：partition()函数；
     */

    public int[] quickSort(int[] numbers) {
       if(numbers.length <= 1) return numbers;
       quickSortInternally(numbers, 0, numbers.length -1);
       return numbers;
    }

    private void quickSortInternally(int[] numbers, int start, int end) {
       if(start >= end) return;
       int q = partition(numbers, start, end);
       quickSortInternally(numbers, start, q -1);
       quickSortInternally(numbers, q + 1, end);
    }

    public int partition(int[] numbers,int start, int end){
       int pivot = numbers[end];
       int pivotIndex = start;
       for(int i = start; i < end; i++){
           if(numbers[i] < pivot){
               int temp = numbers[i];
               numbers[i] = numbers[pivotIndex];
               numbers[pivotIndex++] = temp;
           }
       }
       int temp = numbers[pivotIndex];
       numbers[pivotIndex] = numbers[end];
       numbers[end] = temp;

       System.out.println(pivotIndex);
       return pivotIndex;
    }
}
