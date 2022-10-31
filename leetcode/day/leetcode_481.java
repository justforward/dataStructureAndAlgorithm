package leetcode.day;

/*
    思路：
        得到这个神奇数字。
        连续出现1 或2 的次数 等于这个数字的本身

        1221121221221121122…

        计数的值 等于下一个值

        122112122

        12211212212211

        双指针记录前一个数 记录1的个数

        模拟：



 */
public class leetcode_481 {
    public int magicalString(int n) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        int s = 0;
        for (int i = 0; sb.length() < n; i++) {
            char cur = '1';
            if (i % 2 == 1) cur = '2';
            sb.append(cur);
            if (cur == '1') ans++;
            if (sb.length() >= n) break;
            if (sb.charAt(s) == '2') {
                sb.append(cur);
                if (cur == '1') ans++;
            }
            s++;
        }
        return ans;

    }
}
