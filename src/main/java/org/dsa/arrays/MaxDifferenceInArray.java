package org.dsa.arrays;

/**
 * In this method, instead of taking difference of the picked element with every other element, we take the difference with the minimum element found so far. So we need to keep track of 2 things:
 * 1) Maximum difference found so far (max_diff).
 * 2) Minimum number visited so far (min_element).
 */
public class MaxDifferenceInArray {
    public static void main(String[] args) {
        int arr[] = {2,3,10,6,4,8,1};
        int max_diff = arr[1] - arr[0];
        int min_element = arr[0];
        for(int i =1 ; i<arr.length; i++){
            if(max_diff < arr[i]-min_element){
                max_diff = arr[i] - min_element;
            }
            if(arr[i] < min_element){
                min_element = arr[i];
            }
        }
        System.out.println("Maximum Difference : "+max_diff+" Min Array element : "+min_element);
    }
}
