public class SortAnArrayOf0s1sand2s {
    /*
        Follow the steps below to solve the given problem:

        Keep three counters c0 to count 0s, c1 to count 1s, and c2 to count 2s

        Traverse through the array and increase the count of c0 if the element is 0,
        increase the count of c1 if the element is 1 and increase the count of c2 if the element is 2

        Now again traverse the array and replace the first c0 elements with 0,
        the next c1 elements with 1, and the next c2 elements with 2.
     */
    public static void main(String[] args) {

        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int cnt0s = 0, cnt1s = 0, cnt2s = 0;
        for(int i =0 ; i<arr.length ; i++) {
            switch (arr[i]) {
                case 0:
                    cnt0s++;
                    break;
                case 1:
                    cnt1s++;
                    break;
                case 2:
                    cnt2s++;
                    break;
            }
        }

        //update array index to zero
        int i =0;
        while(cnt0s>0){
            arr[i++] = 0;
            cnt0s--;
        }
        while(cnt1s>0){
            arr[i++] = 1;
            cnt1s--;
        }
        while(cnt2s>0){
            arr[i++] = 2;
            cnt2s--;
        }

        for ( i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}