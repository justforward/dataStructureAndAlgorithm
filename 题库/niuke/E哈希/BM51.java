package 题库.niuke.E哈希;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author tandi
 * @date 2023/3/19 下午1:59
 */
public class BM51 {

    // 1、首先排序
    // 2、排序之后进行遍历找到0值

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Set<ArrayList<Integer>> set = new HashSet<>();
        Arrays.sort(num);
        int n = num.length;
        for (int i = 0; i < num.length-1; i++) {
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                if (num[i] + num[l] + num[r] > 0) {
                    r--;
                } else if (num[i] + num[l] + num[r] < 0) {
                    l++;
                } else {
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(num[i]);
                    tmp.add(num[l]);
                    tmp.add(num[r]);
                    set.add(tmp);
                    l++;
                    r--;
                }
            }
        }
        ans.addAll(set);
        return ans;

    }
}
