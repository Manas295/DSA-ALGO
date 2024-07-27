package org.dsa.strings;

public class LexicographicRankOfString {
    static final int CHAR=256;
    static int fact(int n)
    {
        return (n <= 1) ? 1 : n * fact(n - 1);
    }
    static int lexRank(String str)
    {
        int res = 1;
        int n=str.length();
        int mul= fact(n);
        int[] count=new int[CHAR];  // COMPLEXITY O(CHAR)

        //This is to count the frquency of every character of input string i.e 1 as DISTINCT character in input we assuming for this problem
        for(int i=0;i<n;i++)
            count[str.charAt(i)]++; // COMPLEXITY O(N)

        /*CUMULATIVE Count of every Index I means Sum of all counts from 0 to i-1
         This is doing to get Count of smaller characters  on right side in BIG of O time
         AS we have computed count of every character of input string in above loop
         and we will be having respective count value as 1 and rest index as 0 because we have
         done for the characters present in input string hence eventually in below loop
         we will have count of smaller characters + count(i)
        */
        for(int i=1;i<CHAR;i++)  // COMPLEXITY O(CHAR)
            count[i]+=count[i-1];
        for(int i=0;i<n-1;i++){ // COMPLEXITY O(N*CHAR)NESTED J LOOP RUNNING FOR CHAR TIMES)
            mul=mul/(n-i); //UPDATING MUL factor to calculate the respective factorial of each iteration from total fatorial of N

            //Computing how many smaller characters than this
            res=res+count[str.charAt(i)-1]*mul;
            /*
              We are traversing the string from Left To Right and when come to a character
              we will remove the count from Count arrays once we processed that character
              hence upon traversing the string towards right we already having the count of left
              character removed from count array
              Like STRING -> upon processing S we will remove count of S from COUNt array and
              once we come to T we already having S count removed from that hence we will be having on right
              side of count of charactes left
            */
            for(int j=str.charAt(i);j<CHAR;j++)
                count[j]--;
        }
        return res;
    }
    //TC: O(CHAR+n+CHAR+n*CHAR) = O(n*CHAR)====>O(N) Linear as CHAR is constant
    public static void main(String args[])
    {
        String str = "STRING";
        System.out.print(lexRank(str));
    }
}
