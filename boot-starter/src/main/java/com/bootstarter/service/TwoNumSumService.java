package com.bootstarter.service;

import java.util.HashMap;
import java.util.Map;

/**
 * ******************************
 * author:       Kerwin
 * createTime:   2020/9/23 11:07 上午
 * description:  两数之和业务类
 * version:      V1.0
 * ******************************
 */
public class TwoNumSumService {

    /***
     * 两数之和
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        // 哈希表存储对应的值
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (map.containsKey(value)) {
                result[0] = map.get(value);
                result[1] = i;
                return result;
            } else {
                map.put(nums[i], i);
            }
        }

        return result;
    }
}
