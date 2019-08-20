package geektime.algo.sorts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    private QuickSort quickSort;

    @BeforeEach
    void setUp() {
         quickSort = new QuickSort();
    }

    @Test
    void quickSort() {
        int[] numbers = new int[]{1, 5,6, 2, 3, 4, 7, 10, 24};
        int[] sortedNumbers = quickSort.quickSort(numbers);

        assertArrayEquals(new int[] {1, 2,3,4,5,6,7,10, 24}, sortedNumbers);
    }

}