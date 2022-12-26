package leetcode.day;


/*
    对于某个连续字串aaaaaaaa来说，
    同构字符串aa出现4次，aaaa出现3次，aaaaaa出现2次，aaaaaaaa出现1次。
    可以看出对于长度为nn的相同字母的连续字串，
    同构字符串的出现次数为1 + 2 + ... + n1+2+...+n,
    即(n+1)*n / 2(n+1)∗n/2。
    我们从前往后遍历字符串的每一个字符，统计相同连续字母的子串长度cnt，每次让ans累加长度即可。

 */
public class leetcode_1759 {
    public static void main(String[] args) {
        leetcode_1759 leetcode_1759 = new leetcode_1759();
        System.out.println(leetcode_1759.countHomogenous("abbcccaa"));
    }

    public int countHomogenous(String s) {
        long res = 1, k = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) k++;
            else k = 1;
            res += k;
        }
        return (int) (res % 1000000007);
    }
}
