package util;

/**
 * Created By sunshine on 2018/8/20
 *
 * @Description:
 * @Author: EhangZhang
 */

public class Utils {

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void printArray(int[] array) {
        if (array == null || array.length == 0) return ;
        for (int i : array) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
