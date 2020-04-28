package lql.algo.sort;

import java.util.Arrays;

/**
 * <a href="https://time.geekbang.org/column/article/41913">12 | 排序（下）：如何用快排思想在O(n)内查找第K大元素？</a>
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {4, 5, 6, 3, 2, 1, 7, 9, 3};
        quickSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }

    // 快速排序，A是数组，n表示数组的大小
    public static void quickSort(int[] a, int n) {
        quickSort(a, 0, n-1);
    }

    // 快速排序递归函数，p,r为下标
    private static void quickSort(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }

        // pivot 分区点
        int q = partition(a, p, r);
        quickSort(a, p, q-1);
        quickSort(a, q+1, r);
    }

    // 获取分区点
    private static int partition(int[] a, int p, int r) {
        int i = p;
        for (int j = p; j < r; j++) {
            if (a[j] < a[r]) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, r);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = a[i];
    }
}
