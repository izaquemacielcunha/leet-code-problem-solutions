package com.leetcode.problem.difficult.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    private TwoSum() {}

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numAndIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numAndIndex.containsKey(complement)) {
                return new int[]{numAndIndex.get(complement), i};
            }
            numAndIndex.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solution found");
    }
}// end of class
