package org.dsa.arrays;

public class RemoveDuplicate {
    public static void main(String[] args) {
        int arr[] = {10,20,20,30,30,30};
        int res =1;//index at which next element needs to store
        // & we put initially as 1 to have at least 1 data
        for(int i =1 ; i<arr.length ; i++){
            if(arr[i] != arr[res-1]){
                arr[res] = arr[i];
                res++;
            }
        }
        for(int i = 0 ; i< res; i++){
            System.out.print(arr[i]+" ");
        }

    }
}
