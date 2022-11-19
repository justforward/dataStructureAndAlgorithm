package leetcode.day;

public class leetcode_1732 {
    public static void main(String[] args) {
        leetcode_1732 leetcode_1732 = new leetcode_1732();
        int[] gain = new int[]{-4,-3,-2,-1,4,3,2};
        System.out.println(leetcode_1732.largestAltitude(gain));
    }

    public int largestAltitude(int[] gain) {
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < gain.length; i++) {
            sum += gain[i];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
