package org.dsa.strings;

/*
s1 = ABCD
S2 = AD
A subsequence of a string is obtained by removing zero or more than
1 characters and we need to put the leftover charaters after removing in same order Like above: remobe BC
then put rest of the characters like A and D in same order
 */
public class CheckStringIsSubsequenceOfOther {
    public static void main(String[] args) {
        String str1 = "ABCDEF";
        String str2 = "ADE";//AED
        int n = str1.length();
        int m = str2.length();

        int j=0;
        for(int i=0; i<n && j<m; i++){
            if(str1.charAt(i)==str2.charAt(j)){
                j++;
            }
        }
        if(j==m){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
