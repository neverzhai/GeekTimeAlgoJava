package geektime.algo.sorts;

public class MergeSort {

    /*
    归并排序的思想是分治思想，把数组从中间分成前后两部分，对前后分别排序，在将排序好的合并到一起。
    重要的是哪个merge函数。
     */

    public int[] mergeSort(int[] numbers1, int[] numbers2){
        int totalLength = numbers1.length + numbers2.length;
        int[] sortedNumbers = new int[totalLength];
        int firstIndex = 0;
        int secondIndex = 0;
        int totalIndex = 0;
        while (firstIndex < numbers1.length && secondIndex < numbers2.length){
            if(numbers1[firstIndex] < numbers2[secondIndex]){
               sortedNumbers[totalIndex++] = numbers1[firstIndex++];

            } else if (numbers1[firstIndex] > numbers2[secondIndex]) {
                sortedNumbers[totalIndex++] = numbers2[secondIndex++];
            }else {
                sortedNumbers[totalIndex++] = numbers1[firstIndex++];
                secondIndex++;
            }
        }

        while(firstIndex < numbers1.length){
            sortedNumbers[totalIndex++] = numbers1[firstIndex++];
        }
        while (secondIndex < numbers2.length){
            sortedNumbers[totalIndex++] = numbers2[secondIndex++];
        }

        int[] result = new int[totalIndex];
        for (int index = 0; index < totalIndex; index++) {
            result[index] = sortedNumbers[index];
        }
        return  result;
    }

    // method 1
    public int[] mergeSort(int[] numbers) {
        if(numbers.length <= 1) {
            return  numbers;
        }
        mergeSort(numbers, 0, numbers.length-1);
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

    //method 2
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

    // method 3
    public int[] mergeSortBySentry(int[] numbers) {
        if(numbers.length <= 1){
            return numbers;
        }
        mergeSortBySentry(numbers, 0, numbers.length -1);
        return numbers;
    }

    private void mergeSortBySentry(int[] numbers, int start, int end) {
        if(start >= end)
            return;

        int middle = start + (end - start)/2;
        mergeSortBySentry(numbers, start, middle);
        mergeSortBySentry(numbers, middle + 1, end);
        mergeBySentry(numbers, start, middle, end);
    }

    private void mergeBySentry(int[] numbers, int start, int middle, int end) {
       int leftArrayLength = middle - start + 2;
       int rightArrayLength = end - middle + 1;

       int[] leftTempArray = new int[leftArrayLength];
       int[] rightTempArray = new int[rightArrayLength];

       for(int i = 0; i < leftArrayLength - 1; i++){
           leftTempArray[i] = numbers[start + i];
       }
       leftTempArray[leftArrayLength - 1] = Integer.MAX_VALUE;

       for(int j = 0; j < rightArrayLength - 1; j++){
           rightTempArray[j] = numbers[middle + 1 + j];
       }
       rightTempArray[rightArrayLength - 1] = Integer.MAX_VALUE;

       int leftIndex = 0;
       int rightIndex = 0;
       int tempIndex = start;
       while (tempIndex <= end){
           if(leftTempArray[leftIndex] <= rightTempArray[rightIndex]){
               numbers[tempIndex++] = leftTempArray[leftIndex++];
           }else {
               numbers[tempIndex++] = rightTempArray[rightIndex++];
           }
       }
    }
}

