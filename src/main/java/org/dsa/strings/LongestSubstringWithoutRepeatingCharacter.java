package org.dsa.strings;

import java.util.HashMap;

//O(n)
public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        String[] inputs = {
                "abcabcbb",
                "pwwkew",
                "bbbbb",
                "ababababa",
                "",
                "ABCDEFGHI",
                "ABCDEDCBA",
                "AAAABBBBCCCCDDDD"
        };
        for (int i = 0; i < inputs.length; i++) {
            int str = LongestSubstringWithoutRepeatingCharacter.findLongestSubstring(inputs[i]);
            System.out.print(i + 1);
            System.out.println("\tInput string: " + inputs[i]);
            System.out.println("\n\tLength of longest substring: " + str);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

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
}

