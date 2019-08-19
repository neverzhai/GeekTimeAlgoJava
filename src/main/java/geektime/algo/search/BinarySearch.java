package geektime.algo.search;

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
}
