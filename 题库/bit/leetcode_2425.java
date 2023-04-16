package 题库.bit;

public class leetcode_2425 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{8,6,29,2,26,16,15,29};
        int[] nums2 = new int[]{24,12,12};
        leetcode_2425 l = new leetcode_2425();
        System.out.println(l.xorAllNums(nums1, nums2));
    }

    public int xorAllNums(int[] nums1, int[] nums2) {
//        int n = nums1.length;
//        int m = nums2.length;
//        if (n == m || (n % 2 == 0 && m % 2 == 0)) {
//            return 0;
//        }

        int ans = 0;
        for (int i = 0; i < nums1.length; i++) {
            ans ^= nums1[i];
        }

        for (int j = 0; j < nums2.length; j++) {
            ans ^= nums2[j];
        }
        return ans;
    }
}
