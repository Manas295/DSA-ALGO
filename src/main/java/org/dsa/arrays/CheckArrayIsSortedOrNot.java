package org.dsa.arrays;

public class CheckArrayIsSortedOrNot {
    public static void main(String[] args) {
        int arr[] = { 11, 12, 13, 14, 15, 16, 17 };
        boolean isSorted = checkArraySortedOrNot(arr);
        System.out.println("Array is sorted or not : "+isSorted);
    }

    //O(n)
    private static boolean checkArraySortedOrNot(int[] arr) {
        for(int i =1 ; i<arr.length ; i++){
            if(arr[i] < arr[i-1]){
                return false;
            }
        }
        return true;
    }
}
