package org.dsa.arrays;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    public static void main(String[] args) {
//        int[][][] allIntervals = {
//                {{1, 3}, {8, 10}, {2, 6}, {15, 18}},
//                {{1, 5}, {4, 6}, {6, 8}, {11, 15}},
//                {{3, 7}, {6, 8}, {10, 12}, {11, 15}},
//                {{1, 5}},
//                {{1, 9}, {3, 8}, {4, 4}},
//                {{1, 2}, {3, 4}, {8, 8}},
//                {{1, 5}, {1, 3}},
//                {{1, 5}, {6, 9}},
//                {{0, 0}, {1, 18}, {1, 3}}
//        };
        //        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        int [][]inputInterval = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};

        System.out.println(".\tIntervals to merge: " + Arrays.toString(inputInterval));
        int[][] result = mergeIntervals(inputInterval);
        System.out.println("\tMerged intervals: " + Arrays.deepToString(result));
        System.out.println(new String(new char[100]).replace('\0', '-'));

    }
    public static int[][] mergeIntervals(int[][] intervals) {
        LinkedList<int[]> result = new LinkedList<>();

        if (intervals.length == 0) {
            return new int[][]{};
        }

        result.add(intervals[0]);
        System.out.println("1 -> Interval At 0 "+intervals[0][0]+" , "+intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            System.out.println("1 -> Interval At i "+interval[0]+" , "+interval[1]);
            int[] lastAddedInterval = result.getLast();
            System.out.println("2 -> Last Added Interval "+lastAddedInterval[0]+" , "+lastAddedInterval[1]);
            int currStart = interval[0];
            int currEnd = interval[1];
            int prevEnd = lastAddedInterval[1];

            if (currStart <= prevEnd) {
                lastAddedInterval[1] = Math.max(currEnd, prevEnd);
            } else {
                result.add(new int[]{currStart, currEnd});
            }
            System.out.println("-------------------------");
        }

        return result.toArray(new int[][]{});
    }
}
