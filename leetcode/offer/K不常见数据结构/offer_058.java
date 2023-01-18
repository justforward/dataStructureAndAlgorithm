package leetcode.offer.K不常见数据结构;

import java.util.*;

/*
    1、暴力解法
    2、平衡二叉树：针对开始的
 */

public class offer_058 {

    class MyCalendar {
        TreeMap<Integer, Integer> treeMap;
        public MyCalendar() {
            treeMap = new TreeMap<>();
        }
        public boolean book(int start, int end) {
            // 这个是大于指定元素的最小元素
            Map.Entry<Integer, Integer> integerIntegerCeiling = treeMap.ceilingEntry(start);
            // 小于指定元素的最大元素
            Map.Entry<Integer, Integer> integerIntegerFloor = treeMap.floorEntry(start);

            if (integerIntegerCeiling != null && integerIntegerCeiling.getKey() < end) {
                return false;
            }

            if (integerIntegerFloor.getValue() != null && integerIntegerFloor.getValue() > start) {
                return false;
            }

            treeMap.put(start, end);
            return true;
        }
    }
}
