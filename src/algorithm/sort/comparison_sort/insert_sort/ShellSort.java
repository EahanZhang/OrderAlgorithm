package algorithm.sort.comparison_sort.insert_sort;

/**
 * Created By sunshine on 2018/8/20
 * @Description: 希尔排序
 * @Author: EhangZhang
 */

/**
 * 算法描述：
 *  先将整个待排数组分割成若干个子序列分别进行直接插入排序，然后依次缩减增量再进行排序；
 *  当整个数组基本有序时，再对整个数组进行依次直接插入排序（直接插入排序在数组基本有序时效率很高）
 */
public class ShellSort {
    public static void shellSort(int[] array) {
        if (array == null || array.length <= 1) return ;

        int gap = array.length / 2; // 步长

        while (gap > 0) {
            for (int i = 0; i < gap; i++) { // 直接插入排序
                for (int j = i + gap; j < array.length; j += gap) { // 间隔为gap
                    if (array[j] < array[j - gap]) {
                        int temp = array[j];
                        int k = j - gap;
                        // 寻找第一个小于temp的节点， 并将在其之后的节点分别后移gap长度
                        while (k >= 0 && array[k] > temp) {
                            array[k + gap] = array[k];
                            k -= gap;
                        }
                        // 将值插入
                        array[k + gap] = temp;
                    }
                }
            }
            gap /= 2;
        }

    }
}
