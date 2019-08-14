package geektime.algo.sorts;

import javax.print.attribute.standard.MediaSize;

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
//        for(int j = 0; j < numbers.length; j++){
//            System.out.println(numbers[j]);
//        }
        return numbers;
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

    public void printArray(int[] nums){
        for(int i =0 ; i< nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}

