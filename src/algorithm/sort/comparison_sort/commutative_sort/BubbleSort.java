package algorithm.sort.comparison_sort.commutative_sort;

/**
 * Created By sunshine on 2018/8/20
 * @Description: 冒泡排序
 * @author: EhangZhang
 */

import util.Utils;

/**
 * 算法描述：
 *   1. 冒泡排序算法，从后往前遍历，若结点i的值小于i-1的值，则交换两个值。
 *      因此，第一趟遍历结束时，最小值位于数组第一个元素a[0]。
 *      第二趟接着从后往前遍历到a[1]...一直到整个数组遍历完。
 *   2. 时间复杂度O(n^2).
 *   3. 空间复杂度O(1).
 */

public class BubbleSort {

    public static void bubbleSort(int[] array) {
        if (array == null || array.length <= 1) return ;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 2; j >= i; j--) {
                if (array[j] > array[j + 1]) Utils.swap(array, j, j + 1);
            }
        }
    }


}
