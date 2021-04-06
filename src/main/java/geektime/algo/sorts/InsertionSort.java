package geektime.algo.sorts;

public class InsertionSort {

    /*
    插入排序的思想是区分了已排序区和未排序区，每次将取未排序取中的一个元素，将其插入排序取的正确位置。
    在插入个时候会出现数据搬移
     */
    public int[] insertionSort(int[] numbers){
        if (numbers.length <= 1) return numbers;
        for (int i = 1; i < numbers.length; i++) { // 取未排序区的一个元素
            int value = numbers[i];
            int j = i -1;
            for(; j >= 0; j--){
                if(numbers[j] > value) {
                    numbers[j+1] = numbers[j];  //插入是数据搬移
                }else {
                    break;
                }
            }
            numbers[j+1] = value; // 插入合适的位置
        }
        return numbers;
    }
}
