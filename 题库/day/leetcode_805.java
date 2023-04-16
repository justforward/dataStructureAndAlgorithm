package 题库.day;

/*
       1)得到数组的平分
       2)然后进行排序

nums = [1,2,3,4,5,6,7,8]
输出: true
解释: 我们可以将数组分割为 [1,4,5,8] 和 [2,3,6,7], 他们的平均值都是4.5。
 */
public class leetcode_805 {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        int mid = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        // 每个数组里面可以存放的数量
        mid = sum / 2;
        return false;
    }
}
