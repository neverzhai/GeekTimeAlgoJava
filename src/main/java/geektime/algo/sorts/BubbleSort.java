package geektime.algo.sorts;

public class BubbleSort {

    public int[] bubbleSort(int[] numbers){
        if(numbers.length <= 1) return numbers;

        for(int i = 0; i < numbers.length; i++){
            boolean flag = false;
            for (int j = 0; j < numbers.length - i - 1; j++){
                if(numbers[j] > numbers[j+1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag) break;
        }
        return numbers;
    }
}
