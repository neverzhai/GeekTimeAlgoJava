package geektime.algo.leecode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoNumberSumTest {

   @BeforeEach
   void setUp() {
   }
    @Test
    void twoSum() {
        TwoNumberSum numberSum = new TwoNumberSum();
        int[] nums = {2, 7, 11, 15};
        int[] ints = numberSum.twoSum(nums, 9);
        assertArrayEquals(new int[]{0,1}, ints);
    }

    @Test
    void twoSumWithHash_one() {
        TwoNumberSum numberSum = new TwoNumberSum();
        int[] nums = {2, 7, 11, 15};
        int[] ints = numberSum.twoSumWithHash(nums, 9);
        assertArrayEquals(new int[]{0,1}, ints);
    }

    @Test
    void twoSumWithHash_two() {
        TwoNumberSum numberSum = new TwoNumberSum();
        int[] nums = {3,2,4};
        int[] ints = numberSum.twoSumWithHash(nums, 6);
        assertArrayEquals(new int[]{1,2}, ints);
    }

    @Test
    void twoSumWithHash_three() {
        TwoNumberSum numberSum = new TwoNumberSum();
        int[] nums = {3,3};
        int[] ints = numberSum.twoSumWithHash(nums, 6);
        assertArrayEquals(new int[]{0,1}, ints);
    }
}