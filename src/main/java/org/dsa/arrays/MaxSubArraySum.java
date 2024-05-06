package org.dsa.arrays;

public class MaxSubArraySum {

    /*
    Pseudocode:
    Initialize:
        max_so_far = INT_MIN
        max_ending_here = 0

    Loop for each element of the array
        (a) max_ending_here = max_ending_here + a[i]
        (b) if(max_so_far < max_ending_here)
                max_so_far = max_ending_here
        (c) if(max_ending_here < 0)
                max_ending_here = 0
    return max_so_far

    Follow the below steps to Implement the idea:

    1 Initialize the variables max_so_far = INT_MIN and max_ending_here = 0
    2 Run a for loop from 0 to N-1 and for each index i:
    3 Add the arr[i] to max_ending_here.
        If  max_so_far is less than max_ending_here then update max_so_far  to max_ending_here.
        If max_ending_here < 0 then update max_ending_here = 0
    4 Return max_so_far
     */
    public static void main(String[] args) {
        int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
        int MaxEnding = a[0];
        int res = a[0];

        for(int i=1; i<a.length; i++){
            MaxEnding = Math.max(MaxEnding + a[i],a[i]);
            res = Math.max(MaxEnding,res);

        }
        System.out.println("Max Contiguous Sub Array Sum "+res);
    }
}
