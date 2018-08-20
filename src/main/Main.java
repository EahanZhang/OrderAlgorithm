package main;

import algorithm.sort.comparison_sort.commutative_sort.BubbleSort;
import algorithm.sort.comparison_sort.commutative_sort.QuickSort;
import algorithm.sort.comparison_sort.insert_sort.SimpleInsertSort;

import static util.Utils.printArray;

/**
 * Created By sunshine on 2018/8/20
 *
 * @Description:
 * @Author: EhangZhang
 */

public class Main {

    public static void main(String[] args) {
        int[] array = {22, 22, 31, 21, 15, 8, 41, 22, 66, 1};
        printArray(array);
//        BubbleSort.bubbleSort(array);
//        QuickSort.quickSort(array);
        SimpleInsertSort.simpleInsertSort(array);
        printArray(array);
    }


}
