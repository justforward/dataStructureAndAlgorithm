package leetcode.day;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
    输入：boxes = "001011" 输出：[11,8,5,4,3,4]
    0, 2 4 5
    1, 1

    当前位置和其他1所在下标的相对距离？
 */
public class leetcode_1769 {
    public static void main(String[] args) {
        String boxes = "110";
        leetcode_1769 leetcode_1769 = new leetcode_1769();
        int[] ans = leetcode_1769.minOperations(boxes);
        for (int a : ans) System.out.println(a);
    }

    public int[] minOperations(String boxes) {
        int len = boxes.length();
        int[] ans = new int[len];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int num = boxes.charAt(i) - '0';
            if (num == 1) {
                list.add(i);
            }
        }

        for (int i = 0; i < len; i++) {
            int tmp = 0;
            for (int j = 0; j < list.size(); j++) {
                tmp += Math.abs(list.get(j) - i);
            }
            ans[i] = tmp;
        }
        return ans;
    }
}
