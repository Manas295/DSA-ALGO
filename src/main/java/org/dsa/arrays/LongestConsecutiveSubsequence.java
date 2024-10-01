package org.dsa.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int []arr = {2,9,4,3,10,3,5};
        int len = longestConsecutiveSubsequence(arr);
        System.out.println("Longest Subsequence : "+len);

        int len1 = EfficientLongestSub(arr);
        System.out.println("Longest Subsequence : "+len1);
    }

    //O(nlogn)
    static int longestConsecutiveSubsequence(int []arr){
        Arrays.sort(arr);
        int res=1, curr=1;
        for(int i=1 ; i< arr.length; i++){
            if(arr[i] == arr[i-1]+1){
                curr++;
            }else if(arr[i]!=arr[i-1]){
                res = Math.max(res,curr);
                curr = 1;
            }
        }
        return Math.max(res,curr);
    }

    //O(n)
    static int EfficientLongestSub(int []arr){
        Set<Integer> h = new HashSet<>();
        for(int x : arr){
            h.add(x);
        }
        int res=1;
        for(Integer x : h){
            if(h.contains(x-1)==false){
                int curr=1;
                while(h.contains(x+curr)){
                    curr++;
                }
                res = Math.max(res,curr);
            }
        }
        return res;
    }
}
