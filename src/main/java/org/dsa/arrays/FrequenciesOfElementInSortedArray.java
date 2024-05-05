package org.dsa.arrays;

public class FrequenciesOfElementInSortedArray {
    public static void main(String[] args) {
        int arr[] = {10,10,20,30,30,40,50,50};
        int freq =1 ; // initialising freq as 1 considering 1 frequency atleast
        int i =1; // will traverse from second element of array
        int n = arr.length;
        while(i<n){
            while(i<n && arr[i-1]==arr[i]){// OR if(arr[i-1] == arr[i]
                freq++;
                i++;
            }
            System.out.println(arr[i-1]+" "+freq);
            i++;
            freq=1;
        }
        //this block will be used if second last element is diff of last element
        if(n==1 || arr[n-1]!=arr[n-2]){
            System.out.println(arr[n-1]+ " "+1);
        }
    }
}
