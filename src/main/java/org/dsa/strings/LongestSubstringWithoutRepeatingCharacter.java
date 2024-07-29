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
        for (i = 0; i < n; i++) {
            if (!lastSeenAt.containsKey(str.charAt(i))) {
                lastSeenAt.put(str.charAt(i), i);
                System.out.println("IF BLOCK i -> "+i+"char "+str.charAt(i)+ "WS "+windowStart);
            } else {
                if (lastSeenAt.get(str.charAt(i)) >= windowStart) {
                    windowLength = i - windowStart;
                    if (longest < windowLength) {
                        longest = windowLength;
                    }
                    windowStart = lastSeenAt.get(str.charAt(i)) + 1;
                    System.out.println("ELSE BLOCK i -> "+i+"char "+str.charAt(i)+ "WS "+windowStart);
                }
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
}

