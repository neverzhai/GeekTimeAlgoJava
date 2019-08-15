package geektime.algo.sorts;

import javax.print.attribute.standard.MediaSize;
import java.sql.Statement;

public class MergeSort {

    /*
    归并排序的思想是分治思想，把数组从中间分成前后两部分，对前后分别排序，在将排序好的合并到一起。
    重要的是哪个merge函数。
     */

    public int[] mergeSort(int[] numbers) {
        if(numbers.length <= 1) {
            return  numbers;
        }
        mergeSort(numbers, 0, numbers.length-1);
        return numbers;
    }

    public int[] mergeSortWithTempArray(int[] numbers) {
        if(numbers.length <= 1) {
            return  numbers;
        }

        mergeSortWithTempArray(numbers, 0 , numbers.length -1);
        return numbers;
    }

    private void mergeSortWithTempArray(int[] numbers, int start, int end) {
        if(start >= end){
            return;
        }
        int middle = start + (end -start)/2;
        mergeSortWithTempArray(numbers, start, middle);
        mergeSortWithTempArray(numbers, middle + 1, end);
        mergeByTempArray(numbers, start, middle, end);
    }

    private void mergeSort(int[] nums, int start, int end) {
        if(start >= end) {
            return;
        }
        int middle = start + (end - start) / 2;
         mergeSort(nums, start, middle);
         mergeSort(nums, middle +1, end);
         merge(nums, start, middle, end);

    }

    private void merge(int[] nums, int start, int middle, int end) {
        int leftStartIndex = start, rightStartIndex = middle + 1, tempIndex = 0;
        int[] temp = new int[end - start + 1];
        while(leftStartIndex <= middle && rightStartIndex <= end){
            if(nums[leftStartIndex] > nums[rightStartIndex]){
                temp[tempIndex++] = nums[rightStartIndex++];
            }else {
                temp[tempIndex++] = nums[leftStartIndex++];
            }
        }

//        int a = leftStartIndex;
//        int b = middle;
//        if(rightStartIndex <= end){
//            a = rightStartIndex;
//            b = end;
//        }

//        while (a <= b){
//            temp[tempIndex++] = nums[a++];
//        }
//
        if(leftStartIndex <= middle){
            while (leftStartIndex <= middle){
                temp[tempIndex++] = nums[leftStartIndex++];
            }
        }

        if(rightStartIndex <= end){
            while (rightStartIndex <= end){
                temp[tempIndex++] = nums[rightStartIndex++];
            }
        }

        for(int i = 0; i <= end - start; i++){
            nums[start + i] = temp[i];
        }
    }

    public void mergeByTempArray(int[] nums, int start, int middle, int end){
        int firstTempLength = middle - start + 1;
        int secondTempLength = end - middle;

        int[] firstTempArray = new int[firstTempLength];
        int[] secondTempArray = new int[secondTempLength];

        for(int i = 0; i < firstTempLength; i++){
            firstTempArray[i] = nums[start + i];
        }
        for(int j = 0; j < secondTempLength; j++){
            secondTempArray[j] = nums[middle+1+j];
        }
        int leftIndex = 0;
        int rightIndex = 0;
        int tempIndex = start;

        while(leftIndex < firstTempLength && rightIndex < secondTempLength){
            if(firstTempArray[leftIndex] <= secondTempArray[rightIndex]){
                nums[tempIndex++] = firstTempArray[leftIndex++];
            }else {
                nums[tempIndex++] = secondTempArray[rightIndex++];
            }
        }

        while (leftIndex < firstTempLength){
            nums[tempIndex++] = firstTempArray[leftIndex++];
        }


        while (rightIndex < secondTempLength){
            nums[tempIndex++] = secondTempArray[rightIndex++];
        }

    }

    public void printArray(int[] nums){
        for(int i =0 ; i< nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}

