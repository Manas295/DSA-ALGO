package org.dsa.arrays;

public class LargestElementInArray {
    public static void main(String[] args) {
        int arr[] = { 111, 102, 133, 114, 45, 16, 79 };
        int largest = 0;
        for(int i=1; i<arr.length; i++){
            if(arr[i] > arr[largest]){
                largest = i;
            }
        }
        System.out.println("Largest Element is :" + arr[largest]);
        findSecondLargest(arr);
    }

    public static void findSecondLargest(int arr[]){
        int result=-1;
        int largest = 0;
        for(int i=1; i<arr.length; i++){
            if(arr[i] > arr[largest]){
                result = largest;
                largest = i;
            }
        }
        System.out.println("Second Largest Element is :" + arr[result]);
    }
}
