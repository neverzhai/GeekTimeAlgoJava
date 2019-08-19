package geektime.algo.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    private BinarySearch binarySearch;

    @BeforeEach
    void setUp() {
        binarySearch = new BinarySearch();
    }

    @Test
    void nonRecursionSearch() {
        int[] numbers = new int[] {2, 9, 23, 39, 45, 47};

        int index = binarySearch.NonRecursionSearch(numbers, 23);

        assertEquals(2, index);
    }

    @Test
    void nonRecursionSearch1() {
        int[] numbers = new int[] {2, 9, 23, 39, 45};

        int index = binarySearch.NonRecursionSearch(numbers, 9);

        assertEquals(1, index);
    }



    @Test
    void recursionSearch(){
        int[] numbers = new int[] {2, 9, 23, 39, 45};

        int index = binarySearch.RecursionSearch(numbers, 9);

        assertEquals(1, index);
    }
}