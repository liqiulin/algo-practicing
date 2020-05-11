package lql.algo.sort;

import java.util.Arrays;

/**
 * <a href="https://time.geekbang.org/column/article/41913">12 | 排序（下）：如何用快排思想在O(n)内查找第K大元素？</a>
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 2, 4, 9};
        mergeSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }

    public static void mergeSort(int[] a, int n) {
        mergeSortInternally(a, 0, n-1);
    }

    private static void mergeSortInternally(int[] a, int p, int r) {
        // 递归终止条件
        if (p >= r) {
            return;
        }

        // 取中间位置
        int q = p + (r - p)/2;

        // 分治递归
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q+1, r);

        merge(a, p, q, r);
//        mergeBySentry(a, p, q, r);
    }

    private static void merge(int[] a, int p, int q, int r) {
        // 初始化变量i, j, k
        int i = p;
        int j = q+1;
        int k = 0;

        // 申请一个大小跟a[q...r] 大小相等的数组
        int[] tmp = new int[r-p+1];

        // 合并
        while (i<=q && j<=r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        // 判断哪个子数组有剩余数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        // 把剩余的数据添加到tmp数组
        while (start <= end) {
            tmp[k++] = a[start++];
        }

        // 将tmp数据拷贝回a[p...r]
        for (int n = 0; n < tmp.length; n++) {
            a[p+n] = tmp[n];
        }
    }

    /**
     * 合并（哨兵）
     */
    private static void mergeBySentry(int[] a, int p, int q, int r) {
        int[] left = new int[q - p + 2];
        int[] right = new int[r - q + 1];

        for(int i = 0; i <= q-p; i++) {
            left[i] = a[p+i];
        }
        // 设置left哨兵
        left[q - p + 1] = Integer.MAX_VALUE;

        for(int i = 0; i < r-q; i++) {
            right[i] = a[q + 1 + i];
        }
        // 设置left哨兵
        right[r - q] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = p;
        while (k <= r) {
            if (left[i] <= right[j]) {
                a[k++] = left[i++];
            } else {
                a[k++] = right[j++];
            }
        }
    }
}
