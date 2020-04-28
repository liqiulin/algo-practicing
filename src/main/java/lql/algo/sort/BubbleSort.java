package lql.algo.sort;

import java.util.Arrays;

/**
 *
 * <a href="https://time.geekbang.org/column/article/41802">极客时间： 11 | 排序（上）：为什么插入排序比冒泡排序更受欢迎？</a>
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 3, 2, 1};

        bubbleSort(a, a.length);
        System.out.println(Arrays.toString(a));

        int[] b = {4, 5, 6, 3, 2, 1};
        bubbleSort2(b, b.length);
        System.out.println(Arrays.toString(b));
    }

    /**
     * 冒泡排序只会操作相邻的两个数据。
     * 每次冒泡操作都会对相邻的两个元素进行比较，看是否满足大小关系要求，如果不满足就让它俩互换。
     * 一次冒泡会让至少一个元素移动到它应该在的位置，重复 n 次，就完成了 n 个数据的排序工作。
     * @param a
     */
    public static void bubbleSort(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;

            for (int j = 0; j < n-i-1; j ++) {
                if (a[j] >  a[j+1]) {
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                    flag = true;
                }
            }

            // 没有数据交换，说明数组已经拍好序了
            if (!flag) {
                break;
            }
        }
    }


    /**
     * 练习一下
     * @param a
     */
    public static void bubbleSort2(int[] a, int n) {
        int temp;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n-i-1; j++) {
                if (a[j] > a[j+1]) {
                    temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                    flag = true;
                }
            }

            if (!flag) {
                break;
            }
        }
    }
}
