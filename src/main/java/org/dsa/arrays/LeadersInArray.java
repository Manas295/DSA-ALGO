package org.dsa.arrays;

//A leader in array is the element which highest amongst all its elements in right side of it
public class LeadersInArray {
    //DISCLAIMER : This solution will print leaders from RIGHT--TO--LEFT
    public static void main(String[] args) {
        int arr[] = {7,10,4,10,6,5,2};
        int n = arr.length;
        int curr_leader = arr[n-1];//as last elements will always be a leader
        System.out.println("Current Leader : "+curr_leader);
        for(int i = n-2 ; i>=0 ; i--){
            // if arr[i] is greater than current_leader
            //then current element is also a leader
            if(curr_leader < arr[i]){
                curr_leader = arr[i];
                System.out.println("Current Leader : "+curr_leader);
            }
        }
    }
}
