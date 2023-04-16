package 题库.offer.G字符串;


import java.util.*;

/*
    题目：找到hh:MM 的最小时间差

    归类？同一个小时的、同一个分钟的，是个环形

 */

public class offer_035 {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int M0 = getMinute(timePoints.get(0));
        int ans = Integer.MAX_VALUE;
        int preM = M0;
        for (int i = 1; i < timePoints.size(); i++) {
            int curM = getMinute(timePoints.get(i));
            ans = Math.min(ans, curM - preM);
            preM = curM;
        }

        ans = Math.min(ans, M0 + 24 * 60 - preM);
        return ans;
    }

    public int getMinute(String s) {
        String[] split = s.split(":");
        return Integer.valueOf(split[0]) * 60 + Integer.valueOf(split[1]);
    }


}
