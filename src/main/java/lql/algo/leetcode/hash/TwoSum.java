package lql.algo.leetcode.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/description/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china
 *
 *
 */
public class TwoSum {

    /**
     * 使用HashMap  时间时间复杂度： O(n)  空间复杂度： O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>(nums.length, 1);

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            } else {
                map.putIfAbsent(nums[i], i);
            }
        }

        throw new RuntimeException("param invalid");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};

        TwoSum twoSum = new TwoSum();
        int[] ret = twoSum.twoSum(nums, 6);
        System.out.println(Arrays.toString(ret));
    }
}
