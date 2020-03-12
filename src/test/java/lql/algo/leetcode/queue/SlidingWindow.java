package lql.algo.leetcode.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindow {

    Deque<Integer> deq;
    int[] nums;

    public int[] maxSlidingWindow(int[] nums, int k) {
        deq = new ArrayDeque<>(k);
        this.nums = nums;

        if (nums.length == 0) return new int[0];
        if (k == 1) return nums;

        int[] ret = new int[nums.length - k + 1];

        // 处理第一个窗口数据
        for (int i = 0; i < k; i++) {
            clean(i, k);
            deq.addLast(i);
        }
        ret[0] = nums[deq.getFirst()];

        // 滑动窗口
        for (int i = k; i < nums.length; i++) {
            clean(i, k);
            deq.addLast(i);
            ret[i - k + 1] = deq.getFirst();
        }

        return ret;
    }

    private void clean(int i, int k) {
        // 清除滑动窗口外的下标
        if (!deq.isEmpty() && deq.getFirst() == (i - k)) {
            deq.pollLast();
        }

        // 清除deq中小于当前下标值的下标
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) {
            deq.pollLast();
        }
    }
}
