package org.dsa.arrays;

public class LeftRotateArrayBy1Place {
    public static void main(String[] args) {
        int arr[] = {2,8,9,4,5,6,7};
        int ele = arr[0];
        int n = arr.length;
        for(int i = 1 ; i<n ; i++){
            arr[i-1] = arr[i];
            System.out.print("[");
            for(int num : arr){
                System.out.print(num+" ,");
            }
            System.out.print("]");
            System.out.println("");
        }
        arr[n-1] = ele;
        System.out.println("------FINAL ARRAY------");
        System.out.print("[");
        for(int num : arr){
            System.out.print(num+" ,");
        }
        System.out.print("]");
    }
}
