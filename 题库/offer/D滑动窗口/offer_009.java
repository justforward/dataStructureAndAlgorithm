package 题库.offer.D滑动窗口;

/*
    nums 中乘积小于k的子数组
    1) 暴力 n*2
    2) 前缀和
    3）滑动窗口 o(n)
        确定当前下标j子数组的个数，满足条件的滑动窗口是[i,j]
        以当前下标为终点找到找到满足条件的子数组个数是：j-i+1
        1）找到当前下标为终点的 满足条件的滑动窗口
        2）不超过给定的值，right++
        3）超过给定的值 left++;

 */
public class offer_009 {
    public static void main(String[] args) {
        offer_009 offer_009 = new offer_009();
        int[] nums = new int[]{10, 5, 2, 6};
        int k = 100;
        System.out.println(offer_009.numSubarrayProductLessThanK2(nums, k));
    }

    // 暴力解法一：
    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            if (tmp < k) ans++;
            for (int j = i + 1; j < nums.length; j++) {
                tmp *= nums[j];
                if (tmp < k) ans++;
                else break;
            }
        }
        return ans;
    }

    // 滑动窗口解法二：
    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        int left = 0, right = 0, ans = 0, n = nums.length;
        int tmp = 1;
        while (right < n) {
            tmp *= nums[right];
            // 需要判断left和right的关系
            while (left <= right && tmp >= k) {
                tmp /= nums[left];
                left++;
            }
            ans += right - left + 1;
            right++;
        }
        return ans;
    }

}
