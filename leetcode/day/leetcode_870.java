package leetcode.day;


import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
    思路：贪心，先对nums1进行从小到大排序，对nums2进行从大到小的排序 然后按照最小满足进行？
        先拿到最大值，如果能打得过就打，打不过就拿自己的垃圾和对方的精锐互换。

 */
public class leetcode_870 {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int[] res = new int[nums2.length];
        PriorityQueue<int[]> maxpq = new PriorityQueue<>(
                (int[] pair1, int[] pair2) -> {
                    return pair2[1] - pair1[1];
                }

        );

        for (int i = 0; i < nums2.length; i++) {
            maxpq.offer(new int[]{i, nums2[i]});
        }

        int left = 0, right = nums1.length - 1;

        Arrays.sort(nums1);

        while (maxpq.size() != 0) {
            int[] pair = maxpq.poll();
            int index = pair[0];
            int value = pair[1];
            if (nums1[right] > value) {
                res[index] = nums1[right];
                right--;
            } else {
                res[index] = nums1[left];
                left++;
            }
        }

        return res;

    }
}
