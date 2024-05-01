import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers nums and an integer target,
return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution,
and you may not use the same element twice.

You can return the answer in any order.

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
public class NumIndexThatAddsUpToTarget {
    public static void main(String[] args) {
        int[] indicesArr = getIndicesOfNumWhichAddsUpToTarget();
        if(indicesArr.length==0){
            System.out.println("Not Found");
        }else{
                System.out.println("Indices are : "+indicesArr[0]+" "+indicesArr[1]);
        }
    }

    public static int[] getIndicesOfNumWhichAddsUpToTarget(){
        int[] arr = {12,7,11,2};
        int target = 9;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0 ; i< arr.length ; i++){
            int complement = target - arr[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(arr[i],i);
        }

        return new int[]{};//Not Solution Found
    }

}
