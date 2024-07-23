package org.dsa.strings;

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
