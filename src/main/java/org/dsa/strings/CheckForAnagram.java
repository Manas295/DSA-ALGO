package org.dsa.strings;

import java.util.Arrays;

public class CheckForAnagram {
    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "szilent";
        //-------O(nlogn)--------
        char[] a1 = s1.toCharArray();
        Arrays.sort(a1);
        String str1 = new String(a1);
        char[] a2 = s2.toCharArray();
        Arrays.sort(a2);
        String str2 = new String(a2);
        System.out.println(str1 == str2);

        boolean res = isAnagram("aabca", "acaba");
        System.out.println("is Anagram " + res);


    }

    static boolean isAnagram(String s1, String s2) {

        //APPROACH 2 - Create a character arrays of 256
        boolean isAnagram = false;
        final int CHAR = 256;
        if (s1.length() != s2.length()) {
            isAnagram = false;
            return isAnagram;
        }
        int count[] = new int[CHAR];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }
        for (int i = 0; i < CHAR; i++) {
            if (count[i] != 0) {
                isAnagram = false;
            } else {
                isAnagram = true;
            }
        }
        return isAnagram;
    }
}