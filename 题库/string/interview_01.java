package 题库.string;

/*
    思路：1）hashMap 没有利用翻转字符串的特性
         2）位运算：没有考虑位置，错误的解法：abcd acdb 虽然得到的结果为0 但是位置有问题

    正确思路：将之前的旋转后的字符串（s2）拼接到 s2 查看是否包含s1即可
 */
public class interview_01 {
    public static void main(String[] args) {
        String s1 = "abcd", s2 = "acdb";
        interview_01 i = new interview_01();
        System.out.println(i.isFlipedString(s1, s2));
    }

    /*
        位运算？
     */
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        StringBuilder s = new StringBuilder(s2);
        s.append(s2);
        if (!s.toString().contains(s1)) {
            return false;
        }
        return true;
    }
}
