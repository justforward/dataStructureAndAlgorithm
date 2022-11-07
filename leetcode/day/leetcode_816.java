package leetcode.day;

import java.util.ArrayList;
import java.util.List;

/*
    直接枚举，对于一个数组按照
    1）先排除（）
    2）再进行枚举 枚举的时候先， 分割 再进行

    string.subString(beginIndex,endIndex) [beginIndex,endIndex)
    string.subString(beginIndex) [beginIndex,...]
 */

public class leetcode_816 {
    public static void main(String[] args) {
        leetcode_816 leetcode_816 = new leetcode_816();
        leetcode_816.ambiguousCoordinates("(123)");
        String s = "012345";
        System.out.println(s.substring(1));
    }

    public List<String> ambiguousCoordinates(String s) {
        List<String> list = new ArrayList<>();
        s = s.substring(1, s.length() - 1);
        System.out.println(s);
        for (int i = 1; i < s.length(); i++) {
            // 分割成两部分，left[0,i] right[i+1,right]
            // 针对left 和right 进行. 拆分
            for (String left : getNum(s.substring(0, i))) {
                for (String right : getNum(s.substring(i))) {
                    list.add(new StringBuilder("(").append(left).append(",").append(" ").append(right).append(")").toString());
                }
            }
        }
        return list;
    }


    // 根据得到的数据进行. 分割
    public List<String> getNum(String num) {
        List<String> list = new ArrayList();
        int i = 1;
        String left, right;
        while (i <= num.length()) {
            left = num.substring(0, i); // 分割【整数】部分
            right = num.substring(i++); // 分割【小数】部分
            if ((!left.equals("0") && left.charAt(0) == '0') || // 对于逗号左侧【整数】，不允许以0开头，除非这个整数就是0本身
                    (!right.isEmpty() && right.charAt(right.length() - 1) == '0')) continue; // 对于逗号右侧【小数】，不允许以0作为结尾
            if (right.isEmpty()) list.add(left);
            else list.add(new StringBuilder(left).append(".").append(right).toString());
        }
        return list;
    }


}
