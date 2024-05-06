package org.dsa.arrays;

public class MaximumConsecutive1sInArray {
    public static void main(String[] args) {
        int arr[] = {0,1,1,0,1,1,1,0,1,1,1,1,1,1,1,1};
        int res =0;
        int curr = 0;
        for(int i = 0; i< arr.length ; i++){
            if(arr[i] ==0){
                curr = 0;
            }else{
                curr++;
                res = Math.max(curr,res); // checking current count of 1 with previous iterated results
            }
        }
        System.out.println("Maximum Consecutive One's are : "+res);
    }
}
