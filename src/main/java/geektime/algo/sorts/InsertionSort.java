package geektime.algo.sorts;

public class InsertionSort {

    public int[] insertionSort(int[] numbers){
        for (int i = 1; i < numbers.length; i++) {
            int value = numbers[i];
            int j = i -1;
            for(; j >= 0; j--){
                if(numbers[j] > value) {
                    numbers[j+1] = numbers[j];
                }else {
                    break;
                }
            }
            numbers[j+1] = value;
        }
        return numbers;
    }
}
