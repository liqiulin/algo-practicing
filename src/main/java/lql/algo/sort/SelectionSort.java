package lql.algo.sort;

import java.util.Arrays;

/**
 * 选择排序
 * <a href="https://time.geekbang.org/column/article/41802">极客时间： 11 | 排序（上）：为什么插入排序比冒泡排序更受欢迎？</a>
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 3, 2, 1, 7, 9, 3};

//        selectionSort(a, a.length);
        practice(a, a.length);
        System.out.println(Arrays.toString(a));
    }

    public static void selectionSort(int[] a, int n) {
        for (int i=0; i < n-1; i++) {
            // 初始最小值等于第一个元素
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            // 交换已排区域后的元素与最小元素
            int temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = temp;
        }
    }

    public static void practice(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }
}
