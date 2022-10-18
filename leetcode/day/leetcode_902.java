package leetcode.day;

/*
    数位dp
    1）直接dp
    2）数位dp+二分法
        容斥原理：先不考虑重叠的情况，把包含于某内容中的所有对象的数目先计算出来，然后再把计数时重复计算的数目排斥出去，使得计算的结果既无遗漏又无重复，这种计数的方法称为容斥原理。

        考虑每一位上的数据选择
        在任意区间内的合法数据为ans(l,x)=dp(x)-dp(l-1)

        如果查询区间的左端点固定为 1，同时 dp(0) = 0，因此答案为 dp(x)

        将[1,x]分成三个部分：
            1）位数和x相同，但是最高位比x小 res1
            2）位数和x相同，但是最高位和x相等 res2
            3）位数小于x res3

        假设在数据x的最高位是k，每一个位可以从1-f中进行选择，所以每个位上的数据是f个
        假设n的数据最高位是m，根据给定的数组是有序的，为了满足条件只能选择最高位是（1,m-1的数）

        根据最高位的数字从有序数组中找到最右的下标


 */

import java.util.ArrayList;
import java.util.List;

public class leetcode_902 {
    int[] nums;

    public int dp(int max) {
        // 得到目标数的每一位
        List<Integer> list = new ArrayList<>();
        while (max > 0) {
            list.add(max % 10);
            max /= 10;
        }
        int n = list.size(), m = nums.length, ans = 0;

        //1、处理位数的max相同的
        for (int i = n - 1, p = 1; i >= 0; i--, p++) {
            // 得到当前位置的最大位
            int cur = list.get(i);

            // 二分找到
            int l = 0, r = m - 1;
            while (l < r) {
                int mid = l + (r - l) >> 1;
                if (nums[mid] <= cur) l = mid;
                else r = mid - 1;
            }

            if (nums[r] > cur) {
                break;
            } else if (nums[r] == cur) {
                // 如果找到当前的值与cur相等，找到最右边第一个与cur相等的值，往后可能还有，需要继续进行处理
                ans += r * (int) Math.pow(m, (n - p));
                if (i == 0) ans++;
            } else if (nums[r] < cur) {
                // 这里往后的方案全部都被统计到
                ans += (r + 1) * (int) Math.pow(m, (n - p));
                break;
            }
        }

        // 2、处理位数比max小的
        for (int i = 1, last = 1; i < n; i++) {
            int cur = last * m;
            ans += cur;
            last = cur;
        }
        return ans;
    }

    public int atMostNGivenDigitSet(String[] digits, int n) {
        int len = digits.length;
        nums = new int[len];
        // 将string的每一位转成数字
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(digits[i]);
        return dp(n);
    }
}
