package org.dsa.strings;
/*
CONTIGUOUS PRESENCE OF PATTERN IN A STRING WILL BE CONSIDERED AS SUCCESS
I/P : geeksforgeeks
pat : frog
O/P : Yes its present

I/P : geeksforgeeks
pat : rseek
O/P : NO

Time Complexity - O(m+(n-m)x CHAR) = O(nxCHAR) where m is pattern length and n is txt length
where m<n and n-m is because we are starting second loop from pattern.length till txt.length
 */
public class AnagramSearch {
    static final int CHAR=256;
    static boolean areSame(int CT[],int CP[]){
        for(int i=0;i<CHAR;i++){
            if(CT[i]!=CP[i]){
                return false;
            }
        }
        return true;
    }

    static boolean isPresent(String txt,String pat){
        int[] CT=new int[CHAR]; //count of txt string chars
        int[] CP=new int[CHAR]; //count of pattern string chars
        for(int i=0;i<pat.length();i++){  // 1st window character count for CT(text) and CP(pattern)
            CT[txt.charAt(i)]++;
            CP[pat.charAt(i)]++;
        }

        //starting from pattern length as count for 1st window already computed
        for(int i=pat.length();i<txt.length();i++){
            //checking if conent for both arrays is same or not before sliding the window
            if(areSame(CT,CP)){
                return true;
            }
            //Adding last character of current window like removing g and adding s
            CT[txt.charAt(i)]++;
            //removing fist character of previous window like removing g
            CT[txt.charAt(i-pat.length())]--;

        }
        return false;
    }

    public static void main(String args[])
    {
        String txt = "geeksforgeeks";
        String pat = "frog";
        if (isPresent(txt, pat))
            System.out.println("Anagram search found");
        else
            System.out.println("Anagram search not found");
    }
}
