package algorithm.sort.comparison_sort.selection_sort;

/**
 * Created By sunshine on 2018/8/20
 * @Description: 最小堆排序
 * @Author: EhangZhang
 */

import util.Utils;

/**
 * 算法描述：
 *   1. 将数组堆化，
 *   2. 对堆化数组排序
 *   3. 取出堆顶元素，重新构造堆。
 *   4. 重复2,3，直到堆为空
 */

public class MinHeapSort {

    private int[] array;

    public MinHeapSort(int[] array) {
        this.array = array;
    }

    public void sort() {
        int len = array.length - 1;             // 数组长度
        int beginIndex = (len - 1) >> 1;   // 第一个非叶子结点的索引

        // 构建堆，
        for (int i = beginIndex; i >= 0; i--) { // 构建堆
            minHeapify(i, len);
        }

        // 对构建的堆排序
        for (int i = len; i >= 0; i--) {
            Utils.swap(array, 0, i);
            minHeapify(0, i - 1);
        }
    }

    /**
     * 检查父节点与子节点是否符合堆要求
     * @param index 需要堆化处理的
     * @param len
     */
    private void minHeapify(int index, int len) {
        int li = (index << 1) + 1; // 左子节点的索引
        int ri = li + 1; // 右子节点的索引

        int cMin = li; // 最小子节点的索引，默认为左子节点

        if (li > len) return ; // 若左子节点的索引大小大于未排序堆的长度，返回
        if (ri <= len && array[li] > array[ri]) cMin = ri; // 若右子节点的值小于左子节点的值，则将最小子节点的索引值改为右子节点的值
        if (array[index] > array[cMin]) {   // 若父节点的值大于最小子节点的值
            Utils.swap(array, index, cMin); // 则交换父节点和最小子节点的值
            minHeapify(cMin, len);         // 判断新的父节点的值是否满足堆的条件
        }
    }


}
