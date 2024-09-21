package org.dsa.strings;

import java.util.*;
/*
Let’s see how we can implement the above algorithm:

1 For each string, compute a 26-element list. Each element in this list represents the frequency of an English
  letter in the corresponding string. This frequency count will be represented as a tuple. For example, “abbccc”
  will be represented as (1, 2, 3, 0, 0, ..., 0). This mapping will generate identical lists for strings that are anagrams.

2 Use this list as a key to insert the strings into a hash map. Between the counts, we’ll insert "#"s such that
  it will look like (“#1#0#1#0#1#0#0#0#1......”). All anagrams will be mapped to the same key in this hash map.

3 While traversing each string, we generate its 26-element list and check if this list is present as a key in the hash map.
  If it does, we’ll append the string to the array corresponding to that key. Otherwise, we’ll add the new key-value pair to the hash map.

4 Return the values of the hash map in a two-dimensional array, since each value will be an individual set of anagrams.
 */
class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs){
      if (strs.length == 0) 
            return new ArrayList<List<String>>();
        // Hashmap for count
        Map<String, List<String>> res = new HashMap<String, List<String>>();

        int[] count = new int[26]; // A place for every single alphabet in our string
        // We will compute the frequency for every string
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()){
                // Calculating the value from 1 to 26 for the alphabet
                int index = c - 'a';
                count[index]++;
            }

            StringBuilder delimStr = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                delimStr.append('#');
                delimStr.append(count[i]);
            }
            
            String key = delimStr.toString();
            if (!res.containsKey(key)) 
                res.put(key, new ArrayList<>());
            // We add the string as an anagram if it matched the content
            // of our res hashmap
            res.get(key).add(s);
        }

        return new ArrayList<>(res.values());
    }

    // Driver code
    public static void main(String[] args) {
        String[][]titles = {
        {"eat", "beat", "neat", "tea"},
        {"duel", "dule", "speed", "spede", "deul", "cars"},
        {"eat", "tea", "tan", "ate", "nat", "bat"},
        {""},
        {"sword", "swords"}, {"pot", "top", "opt"}};

        for(int i = 0; i < titles.length; i++){
           System.out.print(i + 1);
           System.out.println(".\tThe Grouped Anagrams for the list " + Arrays.toString(titles[i]) + " are:");
           
           List<List<String>> gt = groupAnagrams(titles[i]);
           System.out.println("\t" + gt);
           System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
