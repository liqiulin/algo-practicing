package lql.algo.sort;

import java.util.Arrays;

/**
 * 插入排序
 * <a href="https://time.geekbang.org/column/article/41802">极客时间： 11 | 排序（上）：为什么插入排序比冒泡排序更受欢迎？</a>
 */
public class InserttionSort {

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 3, 2, 1, 7, 9, 3};

        insertionSort2(a, a.length);
//        insertionSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }

    public static void insertionSort(int[] a, int n) {
        if (a == null || a.length <= 1) {
            return;
        }

        for (int i = 1; i < n; i++) {
            // 待插入值
            int value = a[i];

            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    // 移动插入位置之后的元素
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }

            // 插入数据
            a[j+1] = value;
        }
    }


    public static void insertionSort2(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 1; i < n; i++) {
            int insertValue = a[i];
            int j = i-1;
            for (; j >= 0; j--) {
                if (a[j] > insertValue) {
                    // 往后移动
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }

            // 插入元素
            a[j+1] = insertValue;
        }
    }

}
