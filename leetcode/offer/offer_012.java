package leetcode.offer;

/*
    首先计算总和，再计算左边总和，如果数组总和等于左边总和的两倍，说明左右相等
    计算左边总和
 */
public class offer_012 {
    public static void main(String[] args) {
        offer_012 offer_012 = new offer_012();
        int[] nums = new int[]{1, 7, 3, 6, 5, 6};
        System.out.println(offer_012.pivotIndex(nums));
    }

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int preNum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
            if (preNum == sum) return i;
            preNum += nums[i];
        }
        return -1;
    }
}
