package 题库.offer;

/*

 */
public class offer_008 {
    public static void main(String[] args) {
        offer_008 offer_008 = new offer_008();
        int target = 11;
        int[] nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1};// 先进后出
        System.out.println(offer_008.minSubArrayLen(target, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        int left = 0, right = 0;
        int tmp = 0;
        while (right < n) {
            tmp += nums[right];
            while (tmp >= target) {
                ans = Math.min(ans, right - left + 1);
                tmp -= nums[left];
                left++;
            }
            right++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;


    }
}
