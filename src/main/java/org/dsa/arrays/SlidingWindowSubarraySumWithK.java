package org.dsa.arrays;

public class SlidingWindowSubarraySumWithK {
    public static int subarraySum(int[] nums, int k) {
        int start = 0, end = 0, sum = 0, count = 0;

        while (end < nums.length) {
            sum += nums[end];

            while (sum > k && start <= end) {
                sum -= nums[start];
                start++;
            }

            if (sum == k) {
                count++;
            }

            end++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 2};
        int k = 5;
        System.out.println("Number of subarrays: " + subarraySum(nums, k)); // Output: 2
    }
}