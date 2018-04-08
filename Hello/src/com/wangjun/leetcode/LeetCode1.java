package com.wangjun.leetcode;

import java.util.Arrays;

/** 
 * @author wangjun 
 * @email  scuwangjun@hotmail.com
 * @time   2018年4月4日 下午11:23:32 
 */
public class LeetCode1 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] result = solution.twoSum(nums, target);
		System.out.println(Arrays.toString(result));
		
	}

}

/*
   给定一个整数数列，找出其中和为特定值的那两个数。
   你可以假设每个输入都只会有一种答案，同样的元素不能被重用。
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
    		int[] result = {-1, -1};
        for(int i = 0; i < nums.length - 1; i++) {
        		for(int j = i + 1; j < nums.length; j++) {
        			if(target == ((nums[i] + nums[j]))) {
        				result[0] = i;
        				result[1] = j;
        			}
        		}
        }
        return result;
    }
}
