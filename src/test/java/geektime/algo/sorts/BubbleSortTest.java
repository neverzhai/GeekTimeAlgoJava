package geektime.algo.sorts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BubbleSortTest {

    private BubbleSort bubbleSort;

    @BeforeEach
    void setUp() {
        bubbleSort = new BubbleSort();
    }

    @Test
    void bubbleSort() {
        int[] numbers = new int[] {4,6,2,8,0};
        int[] sortedNumbers = bubbleSort.bubbleSort(numbers);

        assertArrayEquals(new int[] {0,2,4,6,8}, sortedNumbers);
    }


}