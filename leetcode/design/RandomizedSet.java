package leetcode.design;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomizedSet {
    Random random;
    List<Integer> element;
    HashMap<Integer, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        random = new Random();
        element = new ArrayList<>();
        map = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        // 插入元素，针对重复的元素不允许插入
        if (map.containsKey(val)) {
            return false;
        }
        // 元素不存在 直接插入
        int lastIndex = element.size() - 1;
        map.put(val, lastIndex);
        element.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        // 得到当前值所在下标
        int curIndex = map.get(val);
        // 得到最后一个元素
        int lastElement = element.get(element.size() - 1);

        // 将最后一个元素，放入到需要删除元素的下标中
        element.set(curIndex, lastElement);

        map.put(lastElement, curIndex);
        map.remove(val);

        // 删除元素
        element.remove(element.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int index = random.nextInt(element.size());
        return element.get(index);
    }
}
