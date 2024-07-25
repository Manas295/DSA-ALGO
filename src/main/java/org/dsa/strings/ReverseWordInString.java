package org.dsa.strings;

public class ReverseWordInString {
    public static void main(String[] args) {
        String str1 = "Welcome to GFG";
        char[] str = str1.toCharArray();
        int start = 0;
        for(int end = 0 ; end<str1.length() ; end++){
            if(str[end] == ' '){
                //reverse logic of individual word
                reverse(str,start,end-1);
                start = end+1;
            }
        }
        //reverse logic for last word due to loop end
        reverse(str,start,str.length-1);
        //reverse of whole string
        reverse(str,0,str.length-1);

        System.out.println("Reverse of words in string : "+new String(str));
    }

    static void reverse(char[] str, int low, int high){
        while(low<high){
            char temp = str[low];
            str[low] = str[high];
            str[high] = temp;
            low++;
            high--;
        }
    }
}

