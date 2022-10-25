package day_train.prefix_sum;

import java.util.HashMap;
import java.util.List;

/*
    得到0和1相同的子数组

    1）创建一个hashmap 其中key用来存储cur值，value用来存储当前index

    2）遇到0的时候-1 ，遇到1的时候+1

   3） 如果我们能在哈希表中找到当前的cur值，取出对应的pox，在看当前的 index - pos 是否比 ans 大, 取其中的最优解。

    核心：
        由于上诉遇到0的时候-1，遇到1的时候+1。如果出现的0和1的数量一致的时候，其连续数组的和为0，
        因此我们知道数组前面的 cur 值是什么，在到达该连续数组尾部时就不会变。
        因此我们只需要检查哈希表中是否存在其相同的 cur 值即可！(多读几遍)


 */
public class offer_011 {
    public int findMaxLength(int[] nums) {
        int ans = 0, cur = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] == 0 ? --cur : ++cur;
            if (hashMap.containsKey(nums[i])) {
                ans = Math.max(ans, i - hashMap.get(cur));
            } else {
                hashMap.put(nums[i], i);
            }
        }

        return ans;
    }
}
