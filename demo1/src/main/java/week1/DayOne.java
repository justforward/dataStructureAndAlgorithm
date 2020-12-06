package week1;

import java.util.Arrays;

/**
 * @author wangtan
 * @Date 2020/12/6
 * leetcode: 455. Assign Cookies (Easy)
 * 贪心算法 分配问题
 * 题解：存在比较关系的贪心策略
 * 这里的贪心策略是，给剩余孩子里最小饥饿度的孩子分配最小的能饱腹的饼干。
 * 先排序后选择
 */
public class DayOne {
    public static void main(String[] args) {
        //小孩饥饿度
        int[] g = {10, 9, 8, 7, 10, 9, 8, 7};
        //饼干
        int[] s = {10, 9, 8, 7};
        System.out.println(findContentChildren1(g, s));
    }


    //版本一
    public static int findContentChildren(int[] g, int[] s) {
        //贪心算法——先满足饥饿度最小的孩子
        //1.排序
        int result = 0;
        if (g.length == 0 || s.length == 0) {
            return result;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        //确定初始值
        int begin = -1;
        int firstValue = g[0];
        for (int j = 0; j < s.length; j++) {
            if (s[j] >= firstValue) {
                begin = j;
                break;
            }
        }
        if (begin == -1) {
            return result;
        }
        result++;
        begin++;
        //按照拍好序的数组开始匹配
        for (int i = 1; i < g.length; i++) {
            int need = g[i];
            for (int m = begin; m < s.length; m++) {
                if (s[m] >= need) {
                    result++;
                    begin = m + 1;
                    break;
                }
            }
        }
        return result;
    }

    //版本二：利用while
    public static int findContentChildren1(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0,cookie = 0;
        while (child<g.length&&cookie<s.length) {
            if(g[child]<=s[cookie]){
                //满足条件：小孩个数加一
                child++;
            }
            //否则找下一个饼干
            cookie++;
        }
        return child;
    }

}
