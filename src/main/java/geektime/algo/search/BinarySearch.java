package geektime.algo.search;

import javax.swing.*;
import javax.swing.plaf.MenuBarUI;

/*
  二分思想
 */
public class BinarySearch {

    public int NonRecursionSearch(int[] nums, int value){
        int low = 0;
        int high = nums.length - 1;

        while (low <= high){
            int middle = low + (high - low)/2;
            if(nums[middle] == value){
                return middle;
            }
            if(nums[middle] > value){
                high = middle - 1;
            }else {
                low = middle + 1;
            }
        }
        return -1;
    }

    public int RecursionSearch(int[] numbers, int value) {
        return RecursionSearchInternal(numbers, 0 , numbers.length - 1, value);
    }

    private int RecursionSearchInternal(int[] numbers, int low, int high, int value) {
        if(low > high) return -1;

        int middle = low + (high - low)/2;

        if(numbers[middle] == value){
            return  middle;
        }

        if(numbers[middle] < value){
            return RecursionSearchInternal(numbers, middle + 1, high, value);
        }else {
            return RecursionSearchInternal(numbers, low, middle - 1, value);
        }
    }

    // search the first one that the value equals the given value.
    public int FindFirstIndex(int[] numbers, int value) {
        int low = 0;
        int high = numbers.length - 1;

        while (low <= high){
            int middle = low + (high - low)/2;
            if(numbers[middle] < value){
                low = middle +1;
            }else if(numbers[middle] > value){
                high = middle - 1;
            } else {
                if(middle == 0 || numbers[middle - 1] != value) return middle;
                high = middle - 1;
            }
        }
        return -1;
    }

    public int FindLastIndex(int[] numbers, int value) {
        int low = 0;
        int high = numbers.length - 1;
        while(low <= high){
            int middle = low + (high - low)/2;
            if(numbers[middle] < value){
                low = middle + 1;
            } else if(numbers[middle] > value) {
                high = middle - 1;
            }else {
                if(middle == numbers.length - 1 || numbers[middle + 1] != value)
                    return middle;
                low = middle + 1;
            }
        }
        return -1;
    }

    public int FindFirstIndexThatMoreOrEqualValue(int[] numbers, int value) {

        int low = 0;
        int high = numbers.length - 1;
        while(low <= high){
            int middle = low + (high - low)/2;
            if(numbers[middle] >= value) {
                if(middle == 0 || numbers[middle - 1] < value)
                    return middle;
                else {
                    high = middle -1;
                }
            }
            else {
                low = middle + 1;
            }
        }
        return -1;
    }

    public int FindLastIndexThatLessOrEqualValue(int[] numbers, int value) {
        int low = 0;
        int high = numbers.length - 1;
        while(low <= high){
            int middle = low + (high - low)/2;
            if(numbers[middle] <= value) {
                if(middle == numbers.length - 1 || numbers[middle + 1] > value)
                    return middle;
                else {
                    low = middle + 1;
                }
            }
            else {
                high = middle - 1;
            }
        }
        return -1;
    }
}
