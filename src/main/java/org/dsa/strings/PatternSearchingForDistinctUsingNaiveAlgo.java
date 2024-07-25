package org.dsa.strings;

public class PatternSearchingForDistinctUsingNaiveAlgo {
    /*
    This algo runs in linear time even after nested loops
    because we are saving ouer iteration by updating i in last line
    Let suppose J running more than 0 times in that case we are somehow
    updating i to i+j so we are saving that much iteration in outer loop
    Hence Time Complexity is Theta(n)
    txt = "ABCEABEFABCD";
    pat = "ABCD";
    n=12,m=4
    i=0 : Match will be done till j=2 and then J=3 no match hence i = i+j i.e i= 0+3, i=3
    i=3 : No match i++
    i=4 : J will run till 2 and for J=0 and J=1 match done but J=2 fails hence i=4+2 =6
    i=6 : No match i++
    i=7 : No match i++
    i=8 : All chars matches out of J the loop j==m, print i i.e 8 hence OUTPUT =8
     */
    public static void main(String[] args) {
        String txt = "ABCEABEFABCD";
        String pat = "ABCD";
        int n = txt.length();
        int m = pat.length();
        for(int i=0; i<=n-m; ){
            int j;
            for(j=0 ; j<m ; j++){
                if(pat.charAt(j) != txt.charAt(i+j)){
                    break;
                }
            }
            if(j==m){//means patterns matched
                System.out.println(i+" ");
            }
            if(j==0){//means 1st occurance of character didnt matched
                i++;
            }else{
                i = (i+j); // means some iteration have the pattern match so shifting i accordingly
            }
        }
    }
}
