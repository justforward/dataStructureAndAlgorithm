package leetcode.weekend;

import java.util.HashMap;
import java.util.Stack;

public class l_1 {
    public static void main(String[] args) {
        System.out.println(Integer.valueOf("00"));

        //String[] event1 = new String[]{"08:04", "21:09"}, event2 = {"16:40", "16:46"};
        l_1 l = new l_1();
        //System.out.println(l.haveConflict(event1, event2));
        int[] nums = new int[]{9, 3, 1, 2, 6, 3};
        int k = 3;
        //System.out.println(l.subarrayGCD(nums, k));

        // ["08:04","21:09"]
        //["16:40","16:46"]
    }

    public boolean haveConflict(String[] event1, String[] event2) {
//        HashMap<String, Integer> h = new HashMap<>();
//        HashMap<String, Integer>  = new HashMap<>();

        int[] h = new int[25];
        int[] m = new int[61];
        String[] begin_1 = event1[0].split(":");
        String[] end_1 = event1[1].split(":");

        String[] begin_2 = event2[0].split(":");
        String[] end_2 = event2[1].split(":");


        for (int i = Integer.valueOf(begin_1[0]); i <= Integer.valueOf(end_1[0]); i++) {
            h[i]++;
        }

        for (int i = Integer.valueOf(begin_2[0]); i <= Integer.valueOf(end_2[0]); i++) {
            h[i]++;
        }


        int nums2 = 0;
        for (int i = 0; i < h.length; i++) {
            if (h[i] > 2) {
                return true;
            }
            if (h[i] == 2) {
                nums2++;
            }
        }
        if (nums2 > 1) {
            return true;
        }

        if (nums2 == 1) {
            // 特殊处理相同数？


            // 当前只有一个2的时候 查看分钟
            // 一定在边缘
            // ["01:15","02:00"]
            //["02:00","03:00"]
            Integer integer_1 = Integer.valueOf(end_1[1]);
            Integer integer_2 = Integer.valueOf(begin_2[1]);
            if (integer_2 <= integer_1) {
                return true;
            }
        }


        return false;

    }


    //求最大公约数的方法
    public int gy(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

}
