package lql.algo.sort;

/**
 *  <a href="https://time.geekbang.org/column/article/41913">12 | 排序（下）：如何用快排思想在O(n)内查找第K大元素？</a>
 *
 * 利用快排思想，核心：  q+1 = k, return q;  q+1 > k, 继续f(p...q-1)； 否则 继续f(q+1...r)
 */
public class KthSmallest {

    public static void main(String[] args) {
        int[] a = {60, 10, 30, 50, 70, 20, 40, 80, 90, 100, 110};
        System.out.println(getKthSmallest(a, a.length, 1));
        System.out.println(getKthSmallest(a, a.length, 2));
        System.out.println(getKthSmallest(a, a.length, 3));
        System.out.println(getKthSmallest(a, a.length, 4));
        System.out.println(getKthSmallest(a, a.length, 5));
        System.out.println(getKthSmallest(a, a.length, 6));
        System.out.println(getKthSmallest(a, a.length, 7));
        System.out.println(getKthSmallest(a, a.length, 8));
        System.out.println(getKthSmallest(a, a.length, 9));
        System.out.println(getKthSmallest(a, a.length, 10));
        System.out.println(getKthSmallest(a, a.length, 11));
    }

    public static int getKthSmallest(int[] a, int n, int k) {
        if (k > n) {
            return -1;
        }

        return getKthSmallest(a, 0, n-1, k);
    }

    public static int getKthSmallest(int[] a, int p, int r, int k) {
        int q = partition(a, p, r);
        if (q+1 == k) {
            return a[q];
        } else if (q+1 > k) {
            return getKthSmallest(a, p, q-1, k);
        } else {
            return getKthSmallest(a, q+1, r, k);
        }
    }

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
        a[j] = tmp;
    }
}
