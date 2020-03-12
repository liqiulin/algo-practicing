package lql.algo.leetcode.queue;

import java.util.PriorityQueue;

/**
 * 703. 数据流中的第K大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 */
class KthLargest {
    private final PriorityQueue<Integer> q;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int i : nums) {
            add(i);
        }
    }

    public int add(int n) {
        if (q.size() < k) {
            q.offer(n);
        } else {
            if (q.peek() < n) {
                q.poll();
                q.offer(n);
            }
        }
        return q.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4,5,8,2};
        KthLargest kthLargest = new KthLargest(3, arr);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
//

    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */