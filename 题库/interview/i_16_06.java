package 题库.interview;

import java.util.ArrayList;
import java.util.HashMap;

public class i_16_06 {


    /*
        如果有重复的值？
     */
    public int smallestDifference(int[] a, int[] b) {
        // 合并  [nums1] num -> nums1 ? num-> nums2

        int m = a.length;
        int n = b.length;

        int[] big = new int[m + n];
        HashMap<Integer, ArrayList<Integer>> map_a = new HashMap<>();

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            big[i] = a[i];
        }

        for (int j = 0; j < n; j++) {
            big[j] = b[j];
        }

        for (int k = 0; k < m + n - 1; k++) {
            res = Math.min(res, big[k - 1] - big[k]);
        }


        return 0;

    }
}
