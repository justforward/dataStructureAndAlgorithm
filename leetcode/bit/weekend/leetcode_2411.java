package leetcode.bit.weekend;

import java.util.ArrayList;
import java.util.List;

/*
    题目：
        给你一个长度为 n 下标从 0 开始的数组 nums ，数组中所有数字均为非负整数。
        对于 0 到 n - 1 之间的每一个下标 i ，你需要找出 nums 中一个 最小 非空子数组，
        它的起始位置为 i （包含这个位置），同时有 最大 的 按位或运算值 。|

        请你返回一个大小为 n 的整数数组 answer，其中 answer[i]是开始位置为 i ，按位或运算结果最大，且 最短 子数组的长度。
        子数组 是数组里一段连续非空元素组成的序列。(只要是连续的递增就需要存入？)

    思路：
        1）利用或运算的性质
        首先是O(n^2)的思路：
            从左到右正向遍历 nums，对于 x=nums[i]，
            从 i−1 开始倒着遍历 nums[j]，
            更新 nums[j]=nums[j] ∣ x，
            如果 nums[j] 变大则更新 ans[j]=i−j+1。

        对于两个二进制a和b ，如果a|b=a  从集合角度来说，b是a的子集。


       2) 更加通用的模板；模板可以进行求解两道题
            2.1）求出所有子数组的按位或的结果，以及值等于该结果的子数组的个数。
            2.2）求按位或结果等于任意给定数字的子数组的最短长度/最长长度。

            求出所有子数组的按位或的结果，以及值等于该结果的子数组的个数
            求按位或结果等于任意给定数字的子数组的最短长度/最长长度

        另一个结论是，相同的按位或对应的子数组右端点会形成一个连续的区间，
        从而保证下面去重逻辑的正确性（这一性质还可以用来统计按位或结果及其对应的子数组的个数）。

        据此，我们可以倒着遍历 nums，在遍历的同时，
        用一个数组 ors 维护以 i 为左端点的子数组的按位或的结果，
        及其对应的子数组右端点的最小值。
        继续遍历到 nums[i−1] 时，我们可以把 nums[i−1] 和 ors 中的每个值按位或，合并值相同的结果.

        这样在遍历时，ors 中值最大的元素对应的子数组右端点的最小值，就是要求的最短子数组的右端点。
        ors中值最大的元素对应的子数组右端点的最小值，就是要求的最短子数组的右端点。

 */
public class leetcode_2411 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 2, 1, 3};
        leetcode_2411 l = new leetcode_2411();
        l.smallestSubarrays(nums);
    }


    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        // 按位或的值 + 对应子数组的右端点的最小值  所有按位或的结果都记录在这个ors中
        List<int[]> ors = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            ors.add(new int[]{0, i});
            int k = 0;
            // 根据ors数组的值进行| 操作
            for (int[] or : ors) {
                // 将之前的结果与当前值进行或操作
                or[0] |= nums[i];
                if (ors.get(k)[0] == or[0]) {
                    // 合并相同值，下标取最小的
                    ors.get(k)[1] = or[1];

                } else {
                    ors.set(++k, or);
                }
            }
            // 将后面多余的部分给去掉
            ors.subList(k + 1, ors.size()).clear();
            // 得到第一个里面的 1位置 与i相减+1 得到最长的数组
            ans[i] = ors.get(0)[1] - i + 1;
        }
        return ans;
    }
}
