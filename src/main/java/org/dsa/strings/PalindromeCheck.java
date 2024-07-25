package org.dsa.strings;

public class PalindromeCheck {
    public static void main(String[] args) {
        String str ="NAMAN";
        boolean isPalindrome = isPalindrome(str);
        System.out.println(isPalindrome);
    }
    static boolean isPalindrome(String str){
        int start = 0;
        int end = str.length()-1;
        while(start<end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }else{
                start++;
                end--;
            }
        }
        return true;
    }
}
