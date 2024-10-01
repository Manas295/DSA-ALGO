package org.dsa.strings;

import java.util.HashMap;

//O(n)
public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        String[] inputs = {
                "abcbadbd",
                "pwwkew",
                "bbbbb",
                "ababababa",
                "",
                "ABCDEFGHI",
                "ABCDEDCBA",
                "AAAABBBBCCCCDDDD"
        };
//        for (int i = 0; i < inputs.length; i++) {
//            int str = LongestSubstringWithoutRepeatingCharacter.findLongestSubstring(inputs[i]);
//            System.out.print(i + 1);
//            System.out.println("\tInput string: " + inputs[i]);
//            System.out.println("\n\tLength of longest substring: " + str);
//            System.out.println(new String(new char[100]).replace('\0', '-'));
//        }

        int longestLen = LongestSubstringWithoutRepeatingCharacter.longestUniqueSubstrUsingSlidingWindow("geeksforgeeks");
        System.out.println(longestLen);
//        int naiveRes = NaiveApproachLongestDistinct("abac");
//        System.out.println("naive result "+naiveRes);
    }
    public static int findLongestSubstring(String str) {
        if (str.length() == 0) {
            return 0;
        }
        int n = str.length();
        /*
        Window length and longest keep track of the substring lengths.
         */
        int windowStart = 0, longest = 0, windowLength = 0, i = 0;
        HashMap<Character, Integer> lastSeenAt = new HashMap<Character, Integer>();
        System.out.println("Input string : "+str);
        for (i = 0; i < n; i++) {
            System.out.println("Starting Loop with i = "+i+" & Processing char : "+str.charAt(i)+"");
            if (!lastSeenAt.containsKey(str.charAt(i))) {
                lastSeenAt.put(str.charAt(i), i);
                System.out.println("IF BLOCK -> char "+str.charAt(i)+ " WS "+windowStart);
                System.out.println("----------------------------------------------------");
            } else {
                //This check ensures proper track of window length otherwise if this checks is not putted here we will have
                // wrong point of start of window like may be a character which is repeatitive whose last
                // occurrance is outside of current window or before current window start point
                if (lastSeenAt.get(str.charAt(i)) >= windowStart) {
                    windowLength = i - windowStart;
                    if (longest < windowLength) {
                        longest = windowLength;
                    }
                    windowStart = lastSeenAt.get(str.charAt(i)) + 1;
                    System.out.println("ELSE BLOCK -> char "+str.charAt(i)+ " NEW WS "+windowStart);
                    System.out.println("----------------------------------------------------");
                }
                //Updating the latest index of repeatitive characters
                lastSeenAt.replace(str.charAt(i), i);
            }
        }
        //IF ALL CHARS ARE UNIQUE IT WILL COME OUT OF LOOP AND WE NEED TO SET LONGEST VAR VALUE
        if (longest < i - windowStart) {
            System.out.println("I "+i+ " WS "+windowStart);
            longest = i - windowStart;
        }
        return longest;
    }

    //O(n^2)
    public static int NaiveApproachLongestDistinct(String str){
        int n = str.length();
        int res=0;
        for(int i=0 ; i<n ; i++){
            boolean[] visited = new boolean[256];
            System.out.println("Starting i loop : "+i);
            for(int j=i ; j<n ; j++){
                if(visited[str.charAt(j)]==true){
                    break;
                }else{
                    res = Math.max(res,j-i+1);
                    System.out.println("Char : "+str.charAt(j)+" is Not Visited hence adding it in Array");
                    System.out.println("Current result of longest substring : "+res);
                    visited[str.charAt(j)]=true;
                }
            }
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
        return res;
    }


    /*
    The approach stores the last indexes of already visited characters. The idea is to maintain a window of
    distinct characters and is initialized as single character. We keep extending the window on the right side
    till we see distinct characters.

    When we see a repeating character, we check for the last index of the repeated character:

    If last index of repeated character >= starting index of the current window,
    then we update the starting index of the current window to last index of repeated character + 1 to remove the repeated character.

    If last index of repeated character < starting index of the current window,
    then it means that the repeated character is already outside the current window so the window size remains unchanged.

    After iterating over all the characters, the largest window size will be our answer.
     */
    //Time -- O(n)
    static int longestUniqueSubstr(String s) {
        int n = s.length();
        int res=0;
        // last index of all characters is initialized as -1
        int[] lastIndex = new int[256];
        for(int i=0;i<lastIndex.length;i++){
            lastIndex[i] = -1;
        }
        // Initialize start of current window
        int start = 0;

        //move ned of current wondow or laymen terms me smjhlo ki string ke character by character iterate krna hai
        for(int end =0 ; end<n ;end++){

            //Updating the start index if same character comes in same window so need to realign start pointer
            // to calculate length of substring based on new window start point
            // here lastIndex[s.charAt(end)]+1 means start pointer will be 1 position ahead of last occurance of the character which
            // comes again in the iteration
            start = Math.max(start , lastIndex[s.charAt(end)]+1);

            // Update result if we get a larger window (+1 bcz of loop starting from 0 )
            res = Math.max(res,end-start+1);

            // Update last index of s[end] ---> means updating the updated index of characters in each iteration
            lastIndex[s.charAt(end)] = end;
        }
        return res;
    }


    //Sliding Window
    /*
    - Initialize two pointers left and right with 0, which define the current window being considered.
    - The right pointer moves from left to right, extending the current window.
    - If the character at right pointer is not visited, it’s marked as visited.
    - If the character at right pointer is visited, it means there is a repeating character.
      The left pointer moves to the right while marking visited characters as false until the
      repeating character is no longer part of the current window.
    - The length of the current window (right – left + 1) is calculated and answer is updated accordingly.
     */
    static int longestUniqueSubstrUsingSlidingWindow(String s) {

        // if string length is 0
        if (s.length() == 0)
            return 0;

        // if string length 1
        if (s.length() == 1)
            return 1;

        // if string length is more than 1
        int maxLength = 0;
        boolean[] visited = new boolean[256];

        // left and right pointer of sliding window
        int left = 0, right = 0;
        while (right < s.length()) {

            // If the character is repeated, move left pointer
            // to the right and mark visited characters as false
            // until the repeating character is no longer part
            // of the current window.
            while (visited[s.charAt(right)]) {
                visited[s.charAt(left)] = false;
                left++;
            }

            visited[s.charAt(right)] = true;

            // The length of the current window (right - left + 1)
            // is calculated and answer is updated accordingly
            maxLength = Math.max(maxLength, (right - left + 1));
            right++;
        }
        return maxLength;
    }
}

