package 题库.tree.segment;

/*
题目：
    给你一个整数数组 nums 和一个整数 k 。找到 nums 中满足以下要求的最长子序列：
        1）子序列 严格递增
        2）子序列中相邻元素的差值 不超过 k 。
    请你返回满足上述要求的 最长子序列 的长度。
    子序列 是从一个数组中删除部分元素后，剩余元素不改变顺序得到的数组。

思路：
    在求解「上升子序列」问题时，一般有两种优化方法：
        单调栈 + 二分优化；
        线段树、平衡树等数据结构优化。
   这两种做法都可以用 O(nlogn) 的时间解决，但是对于出现k的值问题，本题需要使用线段树实现
 */

public class leetcode_2407 {
}
