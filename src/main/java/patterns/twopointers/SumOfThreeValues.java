package patterns.twopointers;

import java.util.Arrays;

public class SumOfThreeValues {
    public static void main(String[] args) {
        int[] numsList = {3, 7, 1, 2, 8, 4, 5};
        int target = 10;

    }
    //O(n^2)
    public static boolean findSumOfThree(int nums[], int target) {
        Arrays.sort(nums); //O(nlogn)
        int low, high, triples;
        for (int i = 0; i < nums.length - 2; i++) { // i< length-2 bcz low is i+1
            low = i + 1;
            high = nums.length - 1;

            while (low < high) {
                triples = nums[i] + nums[low] + nums[high];

                if (triples == target) {
                    return true;
                } else if (triples < target) {
                    low++;
                } else {
                    high--;
                }
            }

        }
        return false;
    }
}