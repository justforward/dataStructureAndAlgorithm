package leetcode.day;


/*
    1) 简单模拟
    将本身的数字直接与1010 或者0101进行对比 取最小的那个值

    2）位运算

 */
public class leetcode_1758 {

    public int minOperations(String s) {
        int tmpAns = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - '0';
            if (i % 2 == 1) {
                if (cur != 1) tmpAns++;
            } else {
                if (cur != 0) tmpAns++;
            }
        }

        int tmpAns2 = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - '0';
            if (i % 2 == 1) {
                if (cur != 0) tmpAns2++;
            } else {
                if (cur != 1) tmpAns2++;
            }
        }
        return Math.min(tmpAns, tmpAns2);
    }


}
