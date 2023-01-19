# TreeMap


功能：可以有重复值、排序的map
底层原理：红黑树，自平衡的二叉搜索树。

```
TreeMap<Integer> map=new TreeMap<>();

// 添加元素
map.add();

// 得到最后一个 和 第一个元素

-   first() - 返回集合的第一个元素
-   last() - 返回集合的最后一个元素

-   Higher(element) - 返回大于指定元素(element)的最小元素。
-   lower(element) - 返回小于指定元素(element)的最大元素。

// 一边得到元素 一边删除元素
-   pollFirst() - 返回并从集合中删除第一个元素
-   pollLast() - 返回并从集合中删除最后一个元素


// 返回大于指定元素的最小元素
-   **ceiling(element)** - 返回大于指定元素(element)的那些元素中的最小元素。如果传递的元素(element)存在于树集中，则返回作为参数传递的元素(element)。

// 返回小于指定元素的最大元素
-   **floor(element)** - 返回小于指定元素(element)的元素中最大的元素。如果传递的元素(element)存在于树集中，则返回作为参数传递的元素(element)。


```

# TreeSet

功能：去重，排序的map
底层原理：红黑树、自平衡的二叉搜索树


## 优先队列

小顶堆

```
PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {  
    public int compare(int[] a, int[] b) {  
        return a[1] - b[1];  
    }  
});
```

大顶堆

```
PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {  
    public int compare(int[] a, int[] b) {  
        return a[1] - b[1];  
    }  
});
```


## 统计出现频率最大前k个值




## 和最小的k对数


### 题目

给定两个以升序排列的整数数组 `nums1` 和 `nums2` , 以及一个整数 `k` 。
定义一对值 `(u,v)`，其中第一个元素来自 `nums1`，第二个元素来自 `nums2` 。
请找到和最小的 `k` 个数对 `(u1,v1)`,  `(u2,v2)` ... `(uk,vk)` 。

### 代码

每个下标都从0开始，只要找到下标小于当前的nums2 length的大小，就需要往优先队列中存入值

```
public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {  
    List<List<Integer>> ans = new LinkedList<>();  
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {  
        @Override  
        public int compare(int[] o1, int[] o2) {  
            return (nums1[o1[0]] + nums2[o1[1]]) - (nums1[o2[0]] + nums2[o2[1]]);  
        }  
    });  
  
    for (int i = 0; i < nums1.length; i++) {  
        // 将num2的下标从0开始存放  
        priorityQueue.add(new int[]{i, 0});  
    }  
  
    while (k-- > 0 && !priorityQueue.isEmpty()) {  
        int[] poll = priorityQueue.poll();  
        ans.add(Arrays.asList(nums1[poll[0]], nums2[poll[1]]));  
        // 这里统计的是数直接无法返回？需要统计下标可以  
        if (++poll[1] < nums2.length) {  
            priorityQueue.add(new int[]{poll[0], poll[1]});  
        }  
    }  
    return ans;  
}
```

