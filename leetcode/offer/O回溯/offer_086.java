package leetcode.offer.O回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tandi
 * @date 2023/2/25 下午8:57
 */
public class offer_086 {
    List<List<String>> ans = new ArrayList<>();

    public String[][] partition(String s) {
        a(s, new ArrayList<>());

        String[][] resArr = new String[ans.size()][];
        for (int i = 0; i < ans.size(); i++) {
            List<String> list = ans.get(i);
            resArr[i] = list.toArray(new String[list.size()]);
        }
        return resArr;
    }

    public void a(String s, List<String> tmp) {
        if (s.length() == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (is(s, 0, i)) {
                tmp.add(s.substring(0, i + 1));
                a(s.substring(i + 1), tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public boolean is(String s, int l, int r) {
        if (l == r) return true;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            else {
                l++;
                r--;
            }
        }
        return true;
    }
}
