package leetcode.offer.N数组排序;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * @author tandi
 * @date 2023/2/21 下午10:20
 */
public class offer_075 {
    public static void main(String[] args) {
        offer_075 offer_075 = new offer_075();
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, arr2 = new int[]{2, 1, 4, 3, 9, 6};
        offer_075.relativeSortArray(arr1, arr2);
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int arr : arr1) {
            map.put(arr, map.getOrDefault(arr, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr2.length; i++) {
            int cur = arr2[i];
            if (map.containsKey(cur)) {
                for (int j = 0; j < map.get(cur); j++) {
                    list.add(cur);
                }
                map.remove(cur);
            }
        }

        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = (Integer) iterator.next();
            // 获取Value
            for (int j = 0; j < map.get(key); j++) {
                list.add(key);
            }
        }

        int[] ans = new int[list.size()];
        int index = 0;
        for (int l : list) {
            ans[index++] = l;
        }
        return ans;

    }
}
