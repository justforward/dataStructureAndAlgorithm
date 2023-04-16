package 题库.offer.H回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tandi
 * @date 2023/3/17 下午10:17
 */
public class leetcode_86 {

    List<List<String>> ans = new ArrayList<>();

    public String[][] partition(String s) {
        back(s, 0, new ArrayList<>());
        String[][] res = new String[ans.size()][];

        for (int i = 0; i < ans.size(); i++) {
            List<String> list = ans.get(i);
            res[i] = list.toArray(new String[list.size()]);
        }
        return res;
    }

    public void back(String s, int index, List<String> tmp) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            // 判断从index，到i截取的字符串是否是回文
            String value = s.substring(index, i + 1);
            if (!valid(value)) continue;
            tmp.add(value);
            back(s, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }


    public boolean valid(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
