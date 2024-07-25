package org.dsa.strings;

import java.util.Arrays;

/*
str ="abccbd";
Initially res=-1
create a visited boolean array of 256 size with characters as indexes
(by default boolean value is false for every index)

FROM RIGHT TO LEFT
i=5 ; visited['d']=true
i=4 ; visited['b']=true
i=3 ; visited['c']=true
i=2 ; res = i, i.e res = 2
i=1 ; res = 1 ----------> LEFT MOST FIRST REPEATING CHARACTER OF A STRING
i=0 ; visited['a']=true
 */
public class LeftmostNonRepeatingCharacter {
    static final int CHAR =256;
    public static void main(String[] args) {
        String str = "abbcda";
        System.out.println("----------------");
        int res = leftmostNonRepeatingOneTraversalEfficientSolution(str);
        //leftMostNonRepeatingChar(str);
        System.out.println("result ------ "+str.charAt(res));
    }
    //O(n)
    static int leftMostNonRepeatingChar(String s1) {

        //APPROACH 2 - Create a character arrays of 256
        final int CHAR = 256;
        int[] count = new int[CHAR];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (count[s1.charAt(i)] == 1) {
                    return i;
            }
        }
        return -1;
    }

    static int leftmostNonRepeatingOneTraversalEfficientSolution(String str){
        int []FI = new int[256];
        Arrays.fill(FI,-1);
        for(int i=0; i<str.length(); i++){
            if(FI[str.charAt(i)]==-1){
                FI[str.charAt(i)]=i;
            }else{
                FI[str.charAt(i)]=-2; // because if we make -1 it will go again if block in case eg: b comes
                //again in string
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i=0; i<CHAR; i++){
            if(FI[i]>=0){
                res = Math.min(res,FI[i]);
            }
        }
        return (res==Integer.MAX_VALUE)? -1:res;
    }
}
