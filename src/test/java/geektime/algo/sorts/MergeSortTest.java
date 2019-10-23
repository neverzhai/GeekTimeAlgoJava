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

    @Test
    void mergeSortWithMergeWithTempArray() {
        int[] numbers = new int[]{1, 5,6, 2, 3, 4, 7, 10, 24};
        int[] sortedNumbers = mergeSort.mergeSortWithTempArray(numbers);

        assertArrayEquals(new int[] {1, 2,3,4,5,6,7,10, 24}, sortedNumbers);
    }


    @Test
    void mergeSortWithMergeBySentry() {
        int[] numbers = new int[]{1, 5,6, 2, 3, 4, 7, 10, 24};
        int[] sortedNumbers = mergeSort.mergeSortBySentry(numbers);

        assertArrayEquals(new int[] {1, 2,3,4,5,6,7,10, 24}, sortedNumbers);
    }

    @Test
    void merge() {
        int[] numbers1 = new  int[] {2,10,14,19,51,71};
        int[] numbers2 = new int[] {2,9,10,14,19,40,51};
        int[] sortedNumbers = mergeSort.mergeSort(numbers1, numbers2);

        assertArrayEquals(new int[] {2,9,10,14,19,40,51,71} ,sortedNumbers);
    }
}