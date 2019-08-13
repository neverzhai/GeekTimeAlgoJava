package geektime.algo.sorts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    private InsertionSort insertionSort;

    @BeforeEach
    void setUp() {
        insertionSort = new InsertionSort();
    }

    @Test
    void insertionSort() {
        int[] numbers = new int[] {4,6,2,8,0};
        int[] sortedNumbers = insertionSort.insertionSort(numbers);
        assertArrayEquals(new int[] {0,2,4,6,8}, sortedNumbers);
    }
}