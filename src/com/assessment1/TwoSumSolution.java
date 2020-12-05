package com.assessment1;

import java.util.HashMap;

class TwoSumSolution {
    //1.双循环暴力搜，复杂度平方阶
//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target)
//                    return new int[]{i, j};
//            }
//        }
//        return null;
//    }

    //2.hashmap，复杂度线性阶
    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();

        /*for()遍历nums[],向hashmap中不断放入(nums[i],i), (KV反向存储
        直到map中存在另一对应数，只需要遍历一次*/
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]), i};
            else map.put(nums[i], i);
        }
        return null;
    }
}
