package patterns.twopointers;

import java.util.Arrays;

/*
Here’s how the algorithm works:

Condition 1: If colors[current] is 0, the current pointer points to red.
Swap the elements of colors[current] and colors[start]. Next, move both
the start and current pointers one position forward.

Condition 2: Otherwise, if colors[current] is 1, the current pointer points to white.
Increment the current pointer by 1 to analyze the next element.

Condition 3: Otherwise, colors[current] will be 2, i.e., the current pointer points to blue.
Swap the elements of colors[current] and colors[end]. Next, move the end pointer one position backward.
NOTE : When we decrement the end pointer, the current pointer remains unchanged since it has to
analyze the swapped element to determine if further swapping is required with the start pointer.

The three steps above are repeated until the end pointer becomes less than the current pointer, i.e.,
no elements are left to swap.
 */
public class SortColors {
    public static void main(String[] args) {
        int []arr = {2, 2, 2, 0, 1, 0};
        int[] sortedColors = sortColors(arr);
        System.out.println("\n\tThe sorted array is: " + Arrays.toString(sortedColors));

    }

    public static int[] sortColors(int[] colors) {
        int start =0;
        int current =0;
        int end = colors.length-1;
        while (current<=end){
            if(colors[current]==0){
                int temp = colors[start];
                colors[start]=colors[current];
                colors[current]=temp;
                current++;
                start++;
            }
            else if(colors[current]==1){
                current++;
            }
            else if(colors[current]==2){
                int temp = colors[end];
                colors[end]=colors[current];
                colors[current]=temp;
                end--;
            }
        }
        return colors;
    }
}
