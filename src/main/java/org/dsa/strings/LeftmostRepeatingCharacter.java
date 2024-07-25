package org.dsa.strings;
/*
str ="abccbd";
Initially res=-1
create a visited boolean array of 256 size with characters as indexes
(by default boolean value is false for every index)

FROM RIGHT TO LEFT
i=5 ; visited['d']=true
i=4 ; visited['b']=true
i=3 ; visited['c']=true
i=2 ; res = i, i.e res = 2
i=1 ; res = 1 ----------> LEFT MOST FIRST REPEATING CHARACTER OF A STRING
i=0 ; visited['a']=true
 */
public class LeftmostRepeatingCharacter {
    static final int CHAR =256;
    public static void main(String[] args) {
        String str = "abccbd";
        int res = leftMost(str);
        System.out.println(res);
    }
    //O(n)
    static int leftMost(String str){
        boolean[] visited = new boolean[CHAR];//ASCII values size array eithe declare 256 or 26 (need to subtract ascii of 'a' for array processing)
        int res =-1;
        System.out.println("ASCII VALUE of 'a' "+(int)'a');
        for(int i = str.length()-1; i>=0; i--){
            if(visited[str.charAt(i)]){
                res = i;
            }else{
                visited[str.charAt(i)] = true;
            }
        }
        return res;
    }

}
