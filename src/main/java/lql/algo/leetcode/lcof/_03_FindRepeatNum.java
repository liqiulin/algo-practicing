package lql.algo.leetcode.lcof;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题03. 数组中重复的数字
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 *
 */
public class _03_FindRepeatNum {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,3,4,2};
        System.out.println(findRepeatNum(nums1)); // 3

        int[] nums2 = {1,2,3};
        System.out.println(findRepeatNum(nums2)); // -1
    }

    public static int findRepeatNum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }
}
