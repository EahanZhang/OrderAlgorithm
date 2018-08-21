package algorithm.sort.comparison_sort.merge_sort;

/**
 * Created By sunshine on 2018/8/20
 * @Description: 二路归并排序
 * @Author: EhangZhang
 */

/**
 * 算法描述：
 *   二路归并排序的思想是，将一个数组分成两个子数组，
 *   将这两个子数组分别排好序后，再将两个数组重新整合成一个新的数组。
 *   合并后的数组即为排好序的数组
 */

public class TwowayMegerSort {

    public static void mergeSort(int[] array) {
        // 若数组为空或长度小于等于，无序排序，直接返回
        if (array == null || array.length <= 1) return ;

        // 用于保存合并后结果的数组
        int[] res = new int[array.length];
        mergeSortHelp(array, res, 0, array.length - 1);
    }

    private static void mergeSortHelp(int[] array, int[] res, int start, int end) {
        // 若起始位置大于结束位置（即子数组的大小小于等于1）或超出边界, 不作任何操作
        if (start >= end || start < 0 || end >= array.length) return ;

        // 递归， 排序两个子数组
        int mid = (start + end) >> 1;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        mergeSortHelp(array, res, start1, end1);
        mergeSortHelp(array, res, start2, end2);

        // 排序
        int k = start;
        while (start1 <= end1 && start2 <= end2) {
            if (array[start1] < array[start2]) res[k++] = array[start1++];
            else res[k++] = array[start2++];
        }

        // 防止两个子数组中有一个先到头另外一个还没有遍历完的情况
        while (start1 <= end1) res[k++] = array[start1++];
        while (start2 <= end2) res[k++] = array[start2++];

        // 最后将res数组的元素复制到array中
        for (int i = start; i <= end; i++) {
            array[i] = res[i];
        }
    }
}
