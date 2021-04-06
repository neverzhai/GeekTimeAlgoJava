package geektime.algo.offer;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-02-24 08:32
 * @description: 数组中重复的数字
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */
public class DuplicateArray1 {

    // 问题分析： 有n个数字范围都在0～n-1的范围内的数字，如果不重复的话， 这n个数字一定就是0～n-1， 正好和数组下标一致。
    // 利用这个特性， 将数组中的元素归位

    public int getDuplicateNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        for (int index = 0; index < numbers.length; index ++) {
            while (numbers[index] != index) {
                // 找到重复的
                if(numbers[index] == numbers[numbers[index]]) {
                    return numbers[index];
                }
                // 没重复， 进行交换numbers[index] 和 numbers[numbers[index]]
                int temp = numbers[index];
                numbers[index] = numbers[temp];
                numbers[temp] = temp;
            }
        }

        return -1;
    }
}