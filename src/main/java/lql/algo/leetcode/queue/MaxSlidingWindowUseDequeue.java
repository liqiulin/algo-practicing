package lql.algo.leetcode.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 239. 滑动窗口最大值
 *
 * https://leetcode-cn.com/problems/sliding-window-maximum/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china
 *   使用dequeue O(n)
 *   <br/>
 *  
 *   <span>
 *    <a href="https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetcode-3/">算法分析</a>
 *   算法非常直截了当：
 *   1、处理前 k 个元素，初始化双向队列。
 *   2遍历整个数组。在每一步 :
 *   2.1 清理双向队列 :
 *     - 只保留当前滑动窗口中有的元素的索引。
 *     - 移除比当前元素小的所有元素，它们不可能是最大的。
 *   2.2 将当前元素添加到双向队列中。
 *   2.3 将 deque[0] 添加到输出中。
 *   3 返回输出数组。
 *   </span>
 *  
 */
class MaxSlidingWindowUseDequeue {
    /**
     * 存储滑动窗口的元素下标
     */
    private Deque<Integer> deque;

    private int[] nums;

    public int[] maxSlidingWindow(int[] nums, int k) {
        this.nums = nums;
        this.deque = new ArrayDeque<>();

        if (nums.length == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }

        int[] ret = new int[nums.length - k + 1];

        // 处理第一个窗口
        for (int i = 0; i < k; i++) {
            cleanDeque(i, k);
            deque.addLast(i);
        }
        ret[0] = nums[deque.getFirst()];

        // 滑动后续窗口
        for (int i = k; i < nums.length; i++) {
            cleanDeque(i, k);
            deque.addLast(i);
            ret[i - k + 1] = nums[deque.getFirst()];
        }

        return ret;
    }

    private void cleanDeque(int i, int k) {
        // 清除滑动窗口外的下标
        if (!deque.isEmpty() && deque.getFirst() == (i - k)) {
            deque.pollFirst();
        }

        // 清除滑动窗口内所有小于当前下标元素的下标
        while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
            deque.pollLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        MaxSlidingWindowUseDequeue maxSlidingWindow = new MaxSlidingWindowUseDequeue();
        int[] ret = maxSlidingWindow.maxSlidingWindow(nums, k);
        System.out.println("ret:    " + Arrays.toString(ret));
        System.out.println("expect: " + Arrays.toString(new int[]{3, 3, 5, 5, 6, 7}));

        nums = new int[] {1,-1};
        k = 1;
        maxSlidingWindow = new MaxSlidingWindowUseDequeue();
        ret = maxSlidingWindow.maxSlidingWindow(nums, k);
        System.out.println("ret:    " + Arrays.toString(ret));
        System.out.println("expect: " + Arrays.toString(new int[]{1,-1}));

        nums = new int[] {7, 2, 4};
        k = 2;
        maxSlidingWindow = new MaxSlidingWindowUseDequeue();
        ret = maxSlidingWindow.maxSlidingWindow(nums, k);
        System.out.println("ret:    " + Arrays.toString(ret));
        System.out.println("expect: " + Arrays.toString(new int[]{7, 4}));


        nums = new int[] {1,3,1,2,0,5};
        k = 3;
        maxSlidingWindow = new MaxSlidingWindowUseDequeue();
        ret = maxSlidingWindow.maxSlidingWindow(nums, k);
        System.out.println("ret:    " + Arrays.toString(ret));
        System.out.println("expect: " + Arrays.toString(new int[]{3,3,2,5}));
    }
}
