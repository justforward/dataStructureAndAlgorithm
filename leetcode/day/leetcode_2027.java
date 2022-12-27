package leetcode.day;


/*
    找到连续的XXX 一次合并，
    快慢指针
 */
public class leetcode_2027 {

    public static void main(String[] args) {
        leetcode_2027 leetcode_2027 = new leetcode_2027();
        System.out.println(leetcode_2027.minimumMoves("XXXOX"));
    }

    public int minimumMoves(String s) {
        // 只要遇到X的，就往后偏移3位
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X') {
                ans++;
                i += 2;
            }
        }
        return ans;
    }
}
