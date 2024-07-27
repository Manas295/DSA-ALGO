package org.dsa.strings;

public class StringsAreRotationOfEachOther {
    //Linear Time - O(n)
    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "CDAB";
        System.out.println(areRotation(s1,s2));

    }

    static boolean areRotation(String s1 , String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        return ((s1+s1).indexOf(s2)>=0);
    }
}
