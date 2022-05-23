package com.wj.study.easy.array;

/**
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 */
public class leetcode485 {

    //遍历
    public int findMaxConsecutiveOnes(int[] nums) {

        int maxlen = 0;
        int length = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {
                length++;
                maxlen = Math.max(maxlen, length);
            } else {
                length = 0;
            }
        }
        return maxlen;
    }

    //滑动窗口
    public int findMaxConsecutiveOnes1(int[] nums) {

        int first = 0;
        int maxlen = 0;
        int temp = 0;
        while (first < nums.length) {
            if (nums[first] == 1) {
                first++;
            } else {
                int len = first - temp;
                maxlen = Math.max(len, maxlen);
                temp = first + 1;
                first++;
            }
        }
        return Math.max(maxlen, first - temp);
    }


    public static void main(String[] args) {
        int maxConsecutiveOnes = new leetcode485().findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1});
        System.out.println(maxConsecutiveOnes);
    }
}
