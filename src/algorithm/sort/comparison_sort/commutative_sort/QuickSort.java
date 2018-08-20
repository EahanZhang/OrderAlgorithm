package algorithm.sort.comparison_sort.commutative_sort;

/**
 * Created By sunshine on 2018/8/20
 * @Description: 快速排序
 * @Author: EhangZhang
 */

import util.Utils;

/**
 * 算法描述
 * 1. 使用两个指针i和j，初始化时分别指向队首和队尾，初始化分组元素num = a[i]
 * 2. 从j开始向前遍历，若a[j] < a[i], 则交换a[i]与a[j]的值, j--，进入3; 否则, j--，重复2；
 * 3. 从i开始向后遍历，若a[i] > a[j], 则交换a[i]与a[j]的值，i++，进入4; 否则, i++，重复3；
 * 4. 若i < j，重复2和3.
 * 5. 当i >= j时，一次快速排序结束， 此时，所有值小于num的元素都在num的左侧，所有值大于num的元素均在num的右侧，
 *    因此，再对分别对num左侧的元素和对num右侧的元素进行快速排序。
 * 6. 算法结束，此时数组已经有序。
 */
public class QuickSort {

    public static void quickSort(int[] array) {
        if (array == null || array.length <= 1) return ;

        quickSortHelp(array, 0, array.length - 1);
    }

    private static void quickSortHelp(int[] array, int index1, int index2) {
        // 若index1大于等于index2, 无须排序；若指针越界，直接返回。
        if (index1 >= index2 || index2 >= array.length || index1 < 0) return ;

        int start = index1, end = index2;
        int curNum = array[start];

        // 若start < end， 则继续循环
        while (start < end) {
            // 若start元素的值小于end元素的值，且start < end， 则end指针向前移动；
            while (array[start] <= array[end] && start < end) end--;

            // 此时start元素的值大于end元素的值，若start < end, 交换两个元素的值。
            if (start < end) Utils.swap(array, start, end);

            // 若start元素的值小于end元素的值，且start < end， 则start指针向后移动；
            while (array[start] < array[end] && start < end) start++;

            // 此时start元素的值大于end元素的值，若start < end, 交换两个元素的值。
            if (start < end) Utils.swap(array, start, end);
        }

        // 递归进行两个子数组的排序, 且start此时指向的元素为初始队首元素, 直接使用start分割数组。
        quickSortHelp(array, index1, start - 1);
        quickSortHelp(array, start + 1, index2);
    }

}
