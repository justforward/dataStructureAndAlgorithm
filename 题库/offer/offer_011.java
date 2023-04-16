package 题库.offer;

import java.util.HashMap;

/*
    将里面的0转成-1 那么出现前缀和相等的数字 说明出现相同的0或者1

    1）直接记录前缀和的数字，如果出现 也是连续的出现
    2）初始化 map.put(0,-1) 避免出现000111 的情况

 */
public class offer_011 {
    public static void main(String[] args) {
        offer_011 offer_011 = new offer_011();
        int[] nums = new int[]{0, 1};
        System.out.println(offer_011.findMaxLength(nums));
    }

    public int findMaxLength(int[] nums) {
        // 直接记录当前的累加值
        int pre = 0;
        int ans = 0;
        // 必须连续的01 才能出现生成0的时候
        HashMap<Integer, Integer> map = new HashMap<>();
        // 需要初始化的配置
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i] == 0 ? -1 : 1;
            if (map.containsKey(pre)) {
                Integer req = map.get(pre);
                ans = Math.max(ans, i - req);
            } else {
                map.put(pre, i);
            }
        }

        return ans;
    }
}
