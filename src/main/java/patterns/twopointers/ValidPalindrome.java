package patterns.twopointers;

public class ValidPalindrome {
    public static void main(String[] args) {
        String str = "kaYak";
        boolean isValid = checkValidPalindromeOrNot(str);
        System.out.println("isValidPalindrome : "+isValid);
    }
    public static boolean checkValidPalindromeOrNot(String str){
        int i =0;
        int j =str.length()-1;
        while(i<j){
            if(str.charAt(i)==str.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
}
