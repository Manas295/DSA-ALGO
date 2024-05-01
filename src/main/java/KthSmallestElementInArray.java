import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class KthSmallestElementInArray {

    public static void main(String[] args) {
        Integer arr[] = new Integer[] { 12, 3, 5, 7, 19 };
        int K = 2;
        Arrays.sort(arr);
        System.out.println(arr[K-1]);

        //----------APPROACH 2----------------
        Integer arr1[] = new Integer[] { 12, 3, 5, 7, 19 };
        int K1 = 3;
        int N = arr1.length;
        // since counting starts from 0 so to find kth
        // element we need to reduce K by 1
        K1--;
        Set<Integer> integerSet = new TreeSet<Integer>();
        for(int i =0 ; i<arr1.length; i++){
            integerSet.add(arr1[i]);
        }
        Iterator<Integer> itr = integerSet.iterator();
        if(K1 < N){
            while(K1>0){
                itr.next();
                K1--;
            }
            System.out.println("K th Samllest Element "+itr.next());
        }

    }
}
//COMPLEXITY -> O(NlogN)