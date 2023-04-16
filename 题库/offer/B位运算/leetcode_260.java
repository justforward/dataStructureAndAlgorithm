package 题库.offer.B位运算;

/**
 * @author tandi
 * @date 2023/3/19 下午1:53
 */
public class leetcode_260 {

    // 将两个值分开
    public int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }

        int k = 0;
        for (int i = 0; i < 32; i++) {
            if (((sum >> i) & 1) == 1) {
                k = i;
            }
        }

        for (int num : nums) {
            if (((num >> k) & 1) == 1) ans[0] ^= num;
            else {
                ans[1] ^= num;
            }
        }
        return ans;
    }
}
