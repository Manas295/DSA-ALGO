package org.dsa.arrays;

public class MoveAllZeroesToEnd {
    public static void main(String[] args) {
       // int arr[] = {0,0,0,10,0,0,20};//{8,5,0,10,0,20}
        int[] arr = {0, 1, 0, 3, 12};
        //this pointer is having index at which next non zero value will be placed after swapping
        int index = 0;
        for(int i =0 ; i< arr.length ; i++){
            if(arr[i] != 0){
                int tmp = arr[i];
                arr[i] = arr[index];
                arr[index] = tmp;
                index++;
            }
        }
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
