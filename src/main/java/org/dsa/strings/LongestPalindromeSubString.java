package org.dsa.strings;
/*
To understand the optimal approach, we must first make an important observation,
that is, every palindrome mirrors around its centre. For example, for the palindrome - 'abccba':

This is because the centre around which the palindrome is mirrored, can be between two letters,
and can also be a particular letter. The case of the mirror being a character in the string,
is for odd length palindromes as - 'aba' and the case of the mirror being between characters is for
even length palindromes as given in the images above.

So what is the approach to solve this problem? We're going to consider every index of the string as the middle
point or the centre of a possible palindrome and expand around it. We will expand till we find same characters.

Algorithm
Here's the algorithm to solve the problem:

Traverse the string and consider every index as the centre around which the palindrome is mirrored.
We will encounter two cases (in both the cases, i is the loop variabe):

Case 1: The length of the palindromic substring is even:
If the palindrome is of even length, we will assign 2 pointers namely left and right pointers and
initialize them with values i - 1 and i which is centre and then expand left and right in both directions,
till the condition s[left] == s[right] is satisfied.

Case 2: The length of the palindromic substring is odd:
If the palindromic substring is of odd length, the centre is likely to be a particular character.
In which case, we will assign the same left and right pointers and initialize them with values i and i Note that a single letter can also be a palindrome.s
with i as the centre. Post that, we will again expand around the centre till the condition s[left] == s[right] is satisfied.

While this is done, we will maintain the length of the longest palindromic substring encountered and the substring, and return it.

 */
public class LongestPalindromeSubString {
    public static void main(String[] args) {
        String s = "findnitianhere";
//        int maxlength = 0;
//        String maxPalindrome="";
//        for(int i=0;i<s.length();i++){
//            String oddWord = expand(s,i,i);
//            String evenWord = expand(s,i,i+1);
//            System.out.println("oddWord -> "+oddWord+" evenWord -> "+evenWord);
//            if(oddWord.length()>maxlength){
//                maxPalindrome = oddWord;
//                maxlength=oddWord.length();
//            }
//            if(evenWord.length()>maxlength){
//                maxPalindrome = evenWord;
//                maxlength=evenWord.length();
//            }
//
//        }
//        System.out.println("Max Palindrom String : "+maxPalindrome+" MaxLength : "+maxlength);
        String maxPalindrome = longestPalindrome(s);
        System.out.println("Longest palindrome SubString "+maxPalindrome+" Length : "+maxPalindrome.length());
    }
    public static String expand(String s,int left, int right){
        System.out.println("In Expand Method : String "+s+" left : "+left+" Right : "+right);
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            System.out.println("Inside While Loop");
            left--;
            right++;
        }
        String toRet = s.substring(left+1,right);
        System.out.println("In Expand method ---> "+toRet);
        return toRet;
    }

    //O(n^2)
    static String longestPalindrome(String str) {

        if (str.length() <= 1)
            return str;

        String LPS = "";

        for (int i = 1; i < str.length(); i++) {

            // Consider odd length
            int low = i;
            int high = i;
            while(str.charAt(low) == str.charAt(high)) {
                low--;
                high++;

                if (low == -1 || high == str.length())
                    break;
            }

            String palindrome = str.substring(low+1, high);
            if (palindrome.length() > LPS.length()) {
                LPS = palindrome;
            }

            // Consider even length
            low = i-1;
            high = i;
            while(str.charAt(low) == str.charAt(high)) {
                low--;
                high++;

                if (low == -1 || high == str.length())
                    break;
            }

            palindrome = str.substring(low+1, high);
            if (palindrome.length() > LPS.length()) {
                LPS = palindrome;
            }
        }

        return LPS;
    }
}
