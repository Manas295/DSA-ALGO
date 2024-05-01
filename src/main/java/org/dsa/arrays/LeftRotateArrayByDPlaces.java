package org.dsa.arrays;

/*
    If we observe closely, we can see that a group of array elements is changing its position.
    For example see the following array:
    arr[] = {1, 2, 3, 4, 5, 6, 7} and d = 2. The rotated array is {3, 4, 5, 6, 7, 1, 2}

    The group having the first two elements is moving to the end of the array.
    This is like reversing the array.

    But the issue is that if we only reverse the array, it becomes {7, 6, 5, 4, 3, 2, 1}.
    After rotation the elements in the chunks having the first 5 elements {7, 6, 5, 4, 3}
    and the last 2 elements {2, 1} should be in the actual order as of the
    initial array [i.e., {3, 4, 5, 6, 7} and {1, 2}]but here it gets reversed.
    So if those blocks are reversed again we get the desired rotated array.

    As we are performing reverse operations it is also similar to the following sequence:
    Reverse the first ‘d’ elements
    Reverse last (N-d) elements
    Reverse the whole array.
 */
public class LeftRotateArrayByDPlaces {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        int n = arr.length;
        int d = 6;

        if (d == 0)
            return;
        // in case the rotating factor is
        // greater than array length
        d = d % n;
        System.out.println("D is "+d);
        reverseArray(arr,0,d-1);
        reverseArray(arr,d,n-1);
        reverseArray(arr,0,n-1);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    private static void reverseArray(int[] arr, int start, int end) {
        while(start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }
}
