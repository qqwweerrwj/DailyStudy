package com.wj.study.easy.array;

import java.util.Arrays;

public class leetcode414 {

    public int thirdMax(int[] nums) {

        Arrays.sort(nums);//从小到大
        reverse(nums);
        for (int i = 1, j = 0; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] && j++ == 3) {
                return nums[i];
            }
        }

        return 0;
    }

    public void reverse(int[] nums) {
        int left = 0;
        int right = 0;
        while (left < nums.length) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }

    }
}
