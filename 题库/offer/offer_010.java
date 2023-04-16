package 题库.offer;

import java.util.HashMap;

/*
    1) 暴力求解
        根据当前index 进行遍历[0,index] 从右到左遍历 得到连续的子数组
    2）前缀和：
        1） 暴力里面的实现 是针对每个index 都需要遍历其前缀的数组是否符合条件？
           定义pre[i] 为[0,,,i]里面的所有和 pre[i]=pre[i-1]+nums[i]
           那么[j,,,i]这个子数组的和为k，这个条件可以转换成 pre[i]-pre[j-1]==k
           简单移项可得符合条件的下标 j 需要满足
           pre[j-1]=pre[i]-k
           所以我们考虑i结尾的和为k的连续子数组个数时候，只要统计有多少个前缀和为pre[i]-k 的pre[j]即可

        2）统计以每个num[i] 为结尾，和为k的子数组数量

           利用前缀和数组sum 对于求解以某一个nums[i] 为结尾的，和为k的子数组数量，本质上就是求解在[0,i]中
           sum数组中有多少个值为sum[i+1]-k的数，

 */
public class offer_010 {
    public static void main(String[] args) {
        offer_010 offer_010 = new offer_010();
        int[] nums = new int[]{-1, -1, 1};
        int k = 0;
        System.out.println(offer_010.subarraySum(nums, k));
    }

    public int subarraySum1(int[] nums, int k) {
        //每次都遍历之前的前缀数组
        int n = nums.length, ans = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public int subarraySum(int[] nums, int k) {
        int n = nums.length, ans = 0;
        int[] sum = new int[n + 10];
        // 得到前缀和数组
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 1; i <= n; i++) {
            // 得到当前的前缀和 以及需要拼接的前缀和
            int t = sum[i], d = t - k;
            ans += map.getOrDefault(d, 0);
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        return ans;

    }
}
