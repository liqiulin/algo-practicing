package lql.algo.leetcode.queue;

import java.util.Arrays;

/**
 * 239. 滑动窗口最大值   暴力解法
 * https://leetcode-cn.com/problems/sliding-window-maximum/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china
 */
class MaxSlidingWindowForce {
    /**
     * 暴力方法   O(n*k)
     */
    public int[] maxSlidingWindow_force(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }

        int[] ret = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length - k + 1; i++) {
            int max = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
            }
            ret[i] = max;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        MaxSlidingWindowForce maxSlidingWindow = new MaxSlidingWindowForce();
        int[] ret = maxSlidingWindow.maxSlidingWindow_force(nums, k);
        System.out.println("ret:    " + Arrays.toString(ret));
        System.out.println("expect: " + Arrays.toString(new int[]{3, 3, 5, 5, 6, 7}));
    }
}
