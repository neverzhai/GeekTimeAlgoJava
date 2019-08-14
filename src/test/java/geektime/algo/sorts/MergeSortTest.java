package geektime.algo.sorts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    private MergeSort mergeSort;

    @BeforeEach
    void setUp() {
       mergeSort = new MergeSort();
    }

    @Test
    void mergeSort() {
        int[] numbers = new int[]{1, 5,6, 2, 3, 4};
        int[] sortedNumbers = mergeSort.mergeSort(numbers);

        assertArrayEquals(new int[] {1, 2,3,4,5,6}, sortedNumbers);
    }

    @Test
    void mergeSort2() {
        int[] numbers = new int[]{1, 5,6, 2, 3, 4, 7, 10, 24};
        int[] sortedNumbers = mergeSort.mergeSort(numbers);

        assertArrayEquals(new int[] {1, 2,3,4,5,6,7,10, 24}, sortedNumbers);
    }
}