import java.util.HashMap;
import java.util.Map;
/*
    Given an unsorted array of size n. Array elements are in the range of 1 to n.
    One number from set {1, 2, …n} is missing and one number occurs twice in the array.
    Find these two numbers.
 */
public class FindMissingAndRepeatingNum {
//To check in 1....N
    public static void main(String[] args) {
        int[] arr = { 4, 3, 6, 2, 1, 1 };
        Map<Integer, Boolean> intMap = new HashMap<Integer, Boolean>();
        for(Integer i : arr){
            if(intMap.get(i) == null){
                intMap.put(i , true);
            }
            else{
                System.out.println("Repeating Number "+i);
            }
        }
        //To check under 1 to N
        for(int i =1 ; i<=arr.length;i++){
            if(intMap.get(i) == null){
                System.out.println("Missing .. "+i);
            }
        }
    }
}
