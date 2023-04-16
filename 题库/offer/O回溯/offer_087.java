package 题库.offer.O回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tandi
 * @date 2023/2/25 下午9:51
 */
public class offer_087 {
    ArrayList<String> result = new ArrayList<>();
    ArrayList<Long> list = new ArrayList<>();
    int sum = 0;

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return result;
        com(s, 0);
        return result;
    }

    public void com(String s, int startIndex) {
        if (startIndex == s.length() && sum == 4) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                if (i != list.size() - 1) {
                    sb.append(list.get(i)).append(".");
                } else {
                    sb.append(list.get(i));
                }
            }
            result.add(sb.toString());
            return;
        }
        if (sum >= 4) {
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            // 得到起始位置和当前的遍历字符串
            String str = s.substring(startIndex, i + 1);
            // 如果开头的位置是0，同时这个长度大于1 说明ip无效 需要终止
            if (str.charAt(0) == '0' && str.length() > 1) break;
            // 同时判断这个长度，是否在合理范围内
            long m = Long.parseLong(str);
            if (m >= 0 && m <= 255) {
                list.add(m);
                sum++;
            } else continue;

            // 如果满足条件，携带起始位置进入下一次递归
            com(s, i + 1);
            list.remove(list.size() - 1);
            sum--;
        }
    }
}
