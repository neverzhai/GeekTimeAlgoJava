package geektime.algo.leecode;

import java.util.NoSuchElementException;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-12 15:58
 * @description:
 */
public class MyIterator {

    int[][] _array;

    int currentRow = 0;
    int currentCol = 0;

    int rows;

    public MyIterator(int[][] _array) {
        this._array = _array;
        rows = _array.length;
    }

    public boolean hasNext() {
        return currentRow < rows ;
    }


    public int next() {

        if (currentRow >= rows) {
            throw new NoSuchElementException();
        }

        if (currentCol < _array[currentRow].length) {
            int result = _array[currentRow][currentCol];
            currentCol++;

            if (currentCol == _array[currentRow].length) {
                currentRow++;
                currentCol = 0;
                while (currentRow < rows && _array[currentRow].length ==0) {
                    currentRow++;
                }
            }
            return  result;
        }
        throw new NoSuchElementException();

    }

    public static void main(String[] args) {
        int[][] _array = new int[][]{{1,4,5,6},{2,7,8},{}, {}, {}, {9,6,5},{}, {}};
        MyIterator iterator = new MyIterator(_array);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
