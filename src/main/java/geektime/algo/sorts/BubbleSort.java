package geektime.algo.sorts;

public class BubbleSort {
    /*
    冒泡排序的核心思想是循环n次，每次让一个元素去到正确的位置
    其实也分了已排序区和未排序区
    如果没有交换就可以提前退出，不需要继续循环了
     */
    public int[] bubbleSort(int[] numbers){
        if(numbers.length <= 1) return numbers;

        for(int i = 0; i < numbers.length; i++){ // 循环n次
            boolean flag = false;
            for (int j = 0; j < numbers.length - i - 1; j++){ // 每次让一个元素去到正确位置
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
