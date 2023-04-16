package 题库.day;

import java.util.PriorityQueue;

/*
    双指针
 */
public class leetcode_795 {
    public static void main(String[] args) {
        leetcode_795 leetcode_795 = new leetcode_795();
        int[] nums = new int[]{1, 9, 2, 5, 6};
        int left = 2, right = 8;
        System.out.println(leetcode_795.numSubarrayBoundedMax1(nums, left, right));
    }


    /*

     */
    public int numSubarrayBoundedMax1(int[] nums, int left, int right) {
        int ans = 0, index = -1, tmpAns = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) {
                // k 变成当前的数字下标
                index = i;
                // 当前得到的结果是0
                tmpAns = 0;
            } else if (nums[i] >= left) {
                // 当前数据-
                tmpAns = i - index;
            }
            // 如果小于left的时候 直接拿pre的，因为和pre关联
            ans += tmpAns;
        }
        return ans;
    }

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int ans = 0;
        int first = -1;
        // 构建大跟堆
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            pq.add(cur);
            Integer peek = pq.peek();
            // 满足条件的
            if (isValid(left, right, peek)) {
                ans += i - first;
                System.out.println(ans);
            } else {
                // 直接弹出这数字
                pq.poll();
                first = i;
            }
        }
        return ans;

    }


    public Boolean isValid(int left, int right, int num) {
        if (num >= left && num <= right) {
            return true;
        }

        return false;
    }
}
