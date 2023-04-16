package 题库.day;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tandi
 * @date 2022/10/15 8:19 下午
 */
public class leetcode_1441 {
    public static void main(String[] args) {
        int[] target = new int[]{1, 2};
        int n = 3;
        leetcode_1441 leetcode_1441 = new leetcode_1441();
        leetcode_1441.buildArray(target, n);
    }

    public List<String> buildArray(int[] target, int n) {
        // 简单模拟，和前一个数的差距？
        List<String> res = new ArrayList<>();
        int pre = 0;
        for (int i = 0; i < target.length; i++) {
            if (i != target[i] - 1) {
                for (int j = 1; j < target[i] - pre; j++) {
                    res.add("Push");
                    res.add("Pop");
                }
                res.add("Push");
            } else {
                res.add("Push");
            }
            pre = target[i];

        }

        return res;
    }
}
