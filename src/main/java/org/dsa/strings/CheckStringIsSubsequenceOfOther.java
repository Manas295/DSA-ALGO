package org.dsa.strings;

public class CheckStringIsSubsequenceOfOther {
    public static void main(String[] args) {
        String str1 = "ABCDEF";
        String str2 = "ADE";//AED

        int j=0;
        for(int i=0; i<str1.length() && j<str2.length(); i++){
            if(str1.charAt(i)==str2.charAt(j)){
                j++;
            }
        }
        if(j==str2.length()){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
