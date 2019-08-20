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

    //数组中的有重复值，取第一个匹配的value值
    @Test
    void searchFirstIndexThatValueEqualGivenValue(){
        int[] numbers = new int[] {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        int index = binarySearch.FindFirstIndex(numbers, 8);

        assertEquals(5, index);
    }

    @Test
    void searchFirstIndexThatValueEqualGivenValueWhenHitFirstNumber(){
        int[] numbers = new int[] {1, 1, 1, 5, 6, 8, 8, 8, 11, 18};
        int index = binarySearch.FindFirstIndex(numbers, 1);

        assertEquals(0, index);
    }

    //数组中有重复值，取最后一个匹配的值
    @Test
    void searchLastIndexThatValueEqualGivenValue(){
        int[] numbers = new int[] {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        int index = binarySearch.FindLastIndex(numbers, 8);

        assertEquals(7, index);
    }

    // 找出第一个大于等于给定值的元素
    @Test
    void searchFirstIndexThatMoreOrEqualGivenValue(){
        int[] numbers = new int[] {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        int index = binarySearch.FindFirstIndexThatMoreOrEqualValue(numbers, 4);

        assertEquals(2, index);
    }


    // 找出最后一个小于等于给定值的元素
    @Test
    void searchLastIndexThatLessOrEqualGivenValue(){
        int[] numbers = new int[] {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        int index = binarySearch.FindLastIndexThatLessOrEqualValue(numbers, 7);

        assertEquals(4, index);
    }
}