package algorithm.sort.comparison_sort.selection_sort;

/**
 * Created By sunshine on 2018/8/20
 * @Description: 最大堆排序
 * @Author: EhangZhang
 */

import util.Utils;

/**
 * 算法描述：
 *   1. 将数组堆化，
 *   2. 对堆化数组排序
 *   3. 取出堆顶元素，重新构造堆。
 *   4. 重复2,3，直到堆为空
 *
 */

public class MaxHeapSort {

    private int[] array;

    public MaxHeapSort(int[] array) {
        this.array = array;
    }

    /**
     * 堆排序算法的入口，分为两步
     */
    public void sort() {
        /**
         *  第一步， 将数组堆化
         *  beginIndex = beginIndex = 第一个非叶子节点
         */
        int len = array.length - 1;
        int beginIndex = (len - 1) >> 1;
        for(int i = beginIndex; i >= 0; i--) { // 从第一个非叶子节点开始向根节点堆化
            maxHeapify(i, len);
        }

        /**
         *  第二步，对堆化数据排序
         *  每次都是移出最顶层的根节点A[0]，与最尾部的节点调换， 同时遍历长度减1
         *  然后重新整理被换到根节点的末尾元素，使其符合堆的特性
         *  直到未排序的堆长度为0
         */
        for (int i = len; i > 0; i--) {
            Utils.swap(array, 0, i);
            maxHeapify(0, i - 1);
        }

    }

    /**
     * 调整索引为index处的数据，使其符合堆的特征
     * @param index 需要堆化处理的数据的索引
     * @param len 未排序的堆的长度
     */
    private void maxHeapify(int index, int len) {
        int li = (index << 1) + 1; // 左子节点索引
        int ri = li + 1;           // 右子节点索引

        int cMax = li; // 子节点最大索引， 默认为左子节点

        if (li > len) return ;
        if (ri <= len && array[li] < array[ri]) cMax = ri;
        if (array[cMax] > array[index]) {   // 若父节点的值小于最大子节点的值
            Utils.swap(array, index, cMax); // 则交换父节点和最大子节点的值
            maxHeapify(cMax, len);          // 判断交换后得到的新的父节点是否满足堆条件
        }


    }

}
