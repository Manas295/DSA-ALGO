package org.dsa.arrays;

public class MaxLengthEvenOddSubArray {
    public static void main(String[] args) {
        int arr[] = {5,10,20,6,3,8};
        int res =1 ;
        int curr=1;
        for(int i=1;i< arr.length;i++){
            if((arr[i]%2 == 0 && arr[i-1]%2 != 0) ||
                    (arr[i]%2 != 0 && arr[i-1] % 2 == 0)){
                curr++;
                res = Math.max(res,curr);
                System.out.println("i : "+i+" curr : "+curr+" res : "+res+"");
            }else{
                curr=1;
            }
        }
        System.out.println("Max Length for a SubArray : "+res);
    }
}
