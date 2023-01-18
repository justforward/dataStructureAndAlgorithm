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




