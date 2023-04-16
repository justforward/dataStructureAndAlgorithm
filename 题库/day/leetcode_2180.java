package 题库.day;

public class leetcode_2180 {

    public static void main(String[] args) {
        leetcode_2180 leetcode_2180 = new leetcode_2180();
        System.out.println(leetcode_2180.countEven(30));
    }

    public int countEven(int num) {
        int ans = 0;
        // 数字的和为偶数
        for (int i = 1; i <= num; i++) {
            int sum = sum(i);
            if (sum > 1 && sum % 2 == 0) {
                System.out.println(i + "   " + sum);
                ans++;
            }
        }
        return ans;
    }

    public int sum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
