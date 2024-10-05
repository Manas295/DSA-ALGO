package org.dsa.arrays;

import java.util.Arrays;

public class TwoSumInArray {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int arr[] = twoSum(nums,target);
        System.out.println(nums[arr[0]]+" & "+nums[arr[1]]);
    }
    static int[] twoSum(int arr[],int target){
        Arrays.sort(arr);
        int left = 0; int right = arr.length-1;
        while(left < right){
            int sum = arr[left]+ arr[right];
            if(sum==target){
                return new int[]{left,right};
            }else if(sum<target){
                left++;
            }else{
                right--;
            }
        }
        return new int[]{-1,-1};
    }
}
