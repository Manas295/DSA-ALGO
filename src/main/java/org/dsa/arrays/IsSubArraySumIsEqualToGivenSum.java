package org.dsa.arrays;

public class IsSubArraySumIsEqualToGivenSum {
    public static void main(String[] args) {
        int arr [] ={4,8,12,5};
        int sum =17;
       boolean res = isSubSumEqualToSum(sum,arr);
        System.out.println(res);
    }
    static boolean isSubSumEqualToSum(int sum, int arr[] ){
        int s = 0;
        int curr=0;
        for(int e = 0 ; e<arr.length ; e++ ){
            curr+=arr[e];
            while(sum<curr){
                curr -=arr[s];
                s++;
            }
            if(curr==sum){
                return true;
            }
        }
        return false;
    }
}
