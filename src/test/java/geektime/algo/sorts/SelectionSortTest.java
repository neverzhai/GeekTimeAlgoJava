package geektime.algo.sorts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    private SelectionSort selectionSort;

    @BeforeEach
    void setUp() {
        selectionSort = new SelectionSort();
    }

    @Test
    void selectionSort() {
        int[] numbers = new int[] {4,6,2,8,0};
        int[] sortedNumbers = selectionSort.selectionSort(numbers);
        assertArrayEquals(new int[] {0,2,4,6,8}, sortedNumbers);
    }
}