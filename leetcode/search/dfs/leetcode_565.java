package leetcode.search.dfs;


/*
    思路：从元素中所有的点进行枚举找到最大长度，不断添加直到S出现重复的元素

对每一个循环，无论从哪里进入，结果都是一样的，这是很直观的
由于不存在重复数字，也就是说不可能两个数字指向同一个地方，所以每个循环不存在交叉，因此查找过的元素一定不会被再次查找

一定在开头处成环？

为什么一定会存在环？
1）在没有回头指向遍历过的节点时，这个结构是线性的，但是最终状态不可能是线性的，
因为每个节点都必然指向某个节点，也必然被某个节点所指，所以它不可能真正地有头有尾。最长的可能就是遍历完整个数组，最后返回到某个值并成环。

    将点进行标记：
    根据题意可知，若获得重复元素，必然有该路径下所有的元素会构成一个环路，
    在环上的任意一个点出发，都会回到原点，所以环上的元素只需要遍历一次
 */
public class leetcode_565 {
    public static void main(String[] args) {
        int[] A = new int[]{5, 4, 0, 3, 1, 6, 2};
        leetcode_565 leetcode_565 = new leetcode_565();
        System.out.println(leetcode_565.arrayNesting(A));
    }


    public int arrayNesting(int[] nums) {
        int res = 0;
        boolean[] v = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int tmp = 0;
            while (!v[n]) {
                v[n] = true;
                n = nums[n];
                tmp++;
            }
            res = Math.max(res, tmp);
        }
        return res;
    }


}
