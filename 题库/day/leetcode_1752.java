package 题库.day;


/*
    1、轮转的意思是看成一个首位相连的数组，进行判断 得到

 */
public class leetcode_1752 {
    public boolean check(int[] nums) {
        int t = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                t++;
            }
            if (t > 1) {
                return false;
            }
        }

        return t == 0 || (t == 1 && nums[0] >= nums[nums.length - 1]);

    }
}
