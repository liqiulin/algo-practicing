package lql.algo.leetcode.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/
 */
public class ThreeNums {

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

    }
}
