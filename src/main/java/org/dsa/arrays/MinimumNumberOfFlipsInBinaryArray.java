package org.dsa.arrays;

public class MinimumNumberOfFlipsInBinaryArray {
    public static void main(String[] args) {
        int arr[] = {0,0,1,1,0,0,1,1,0};
        int n = arr.length;
        for(int i =1 ; i< n ; i++){
            if(arr[i]!=arr[i-1]){
                if(arr[i]!=arr[0]){
                    System.out.print("From "+i+" To ");
                }else{
                    System.out.print(i-1);
                    System.out.println();
                }
            }
        }
        //for this scenario arr like : {0,0,1,1,0,0,1,1,0,1} O/P : From 9 To 9;
        if(arr[n-1]!=arr[0]){
            System.out.println(n-1);
        }
    }
}
