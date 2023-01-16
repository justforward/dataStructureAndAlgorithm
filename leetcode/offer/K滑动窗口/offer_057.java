package leetcode.offer.K滑动窗口;


import java.util.LinkedList;
import java.util.Queue;

/*
    快满指针进行？

 */
public class offer_057 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        int k = 3, t = 0;
        offer_057 offer_057 = new offer_057();
        System.out.println(offer_057.containsNearbyAlmostDuplicate(nums, k, t));

    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        int left = 0, right = 0;
        int len = nums.length - 1;
        while (left < len) {
            while (Math.abs(right - left) <= k) {
                if (Math.abs(nums[left] - nums[right]) < t) {
                    return true;
                }
                right++;
            }

            left++;
        }
        return false;

    }

}
