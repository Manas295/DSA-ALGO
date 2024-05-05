package org.dsa.arrays;

public class TrappingRainWaterProblem {
    static int arr[]
            = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

    // Method for maximum amount of water
    static int findWater(int n)
    {
        // leftMax[i] contains height of tallest bar to the
        // leftMax of i'th bar including itself
        int leftMax[] = new int[n];

        // Right [i] contains height of tallest bar to
        // the rightMax of ith bar including itself
        int rightMax[] = new int[n];

        // Initialize result
        int water = 0;

        // Fill leftMax array
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++)
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        for(int i =0; i<leftMax.length ; i++){
            System.out.println("LeftMax : "+leftMax[i]);
        }
        // Fill rightMax array
        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--)
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        for(int i =0; i<rightMax.length ; i++){
            System.out.println("RightMax : "+rightMax[i]);
        }
        // Calculate the accumulated water element by
        // element consider the amount of water on i'th bar,
        // the amount of water accumulated on this
        // particular bar will be equal to min(leftMax[i],
        // rightMax[i]) - arr[i] .
        for (int i = 0; i < n; i++){
            System.out.println("i ----> "+i+" Water : "+water);
            water += Math.min(leftMax[i], rightMax[i]) - arr[i];
            System.out.println("leftmax[i] : "+leftMax[i]+" & rightmax[i] : "+rightMax[i]+"");
        }
        return water;
    }
    public static void main(String[] args) {
        System.out.println(findWater(arr.length));
    }
}
