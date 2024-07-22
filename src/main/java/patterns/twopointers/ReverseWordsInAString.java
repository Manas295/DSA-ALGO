package patterns.twopointers;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        String s ="Hello World!!";
        String[] words = s.split("\\s");
        int left = 0, right = words.length - 1;
        while(left<right){
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        String res = String.join(" ", words);
        System.out.println(res);
    }
}
