package lql.algo.leetcode.lcof;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/">面试题40. 最小的k个数</a>
 */
public class KSmallest {
    public static void main(String[] args) {
        int[] arr = {0,0,2,3,2,1,1,2,0,4};
        QuickSortSolution quickSortSolution = new QuickSortSolution();
        System.out.println(Arrays.toString(quickSortSolution.getLeastNumbers(arr,  10)));
    }
}

/**
 * 大顶堆解法： 时间复杂度 O（NlogN）
 */
//class HeapSolution {
//    public int[] getLeastNumbers(int[] arr, int k) {
//        // 小顶堆
//        Queue<Integer> queue = new PriorityQueue<>((v1, v2) -> v2 - v1);
//        for (int i = 0; i < arr.length; i++) {
//            if (i < k) {
//                queue.offer(arr[i]);
//            } else {
//                queue.poll();
//                queue.offer(arr[i]);
//            }
//        }
//
//    }
//}

/**
 * 快排思路解法：时间复杂度 O(N)
 */
class QuickSortSolution {
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length-1, k);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    private void quickSort(int[] arr, int p, int r, int k) {
        if (p >= r) {
            return;
        }
        int q = partition(arr, p, r);
        if (q == k) {
            return;
        } else if (q > k) {
            quickSort(arr, p, q-1, k);
        } else {
            quickSort(arr, q+1, r, k);
        }
    }

    private int partition(int[] arr, int p, int r) {
        int i = p;
        for (int j = p; j < r; j++) {
            if (arr[j] < arr[r]) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
