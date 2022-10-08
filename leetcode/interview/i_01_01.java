package leetcode.interview;


/*
    思路：
        1）哈希 hash
        1）位计算，二进制的26位

 */
public class i_01_01 {
    public static void main(String[] args) {
        System.out.println('z'-'a');
        System.out.println(1<<2);
//        String s = "iluhwpyk";
//        i_01_01 i = new i_01_01();
//        System.out.println(i.isUnique(s));
    }

    public boolean isUnique(String astr) {
        int len = astr.length();
        //
        int[] tmp = new int[26];
        for (int i = 1; i < len + 1; i++) {
            tmp[i] = astr.charAt(i - 1) - 'a' + 1;
        }

        int bit = 0;
        for (int i = 1; i < len + 1; i++) {
            bit ^= tmp[i];
        }

        for (int i = 1; i < len + 1; i++) {
            bit ^= i;
        }

        return bit == 0;

    }
}
