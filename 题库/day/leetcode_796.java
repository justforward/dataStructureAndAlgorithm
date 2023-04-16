package 题库.day;

/*
        模拟题：
        按照排序结果，值被存放到n-1 位置上

        思路：这个数要比之前的数要大还需要保证他在排完序之后的自己位置上
        你不仅要保证这个数比之前的要大还要保证他在他自己确定的位置上，否则排出来的并不会是有序的数组

        arr={1,2,0,3}

 */
public class leetcode_796 {
    public int maxChunksToSorted(int[] arr) {
        int temp = 0, ans = 0;
        for (int i = 0; i < arr.length; i++) {
            temp = Math.max(temp, arr[i]);
            if (temp == i) {
                ans++;
            }
        }
        return ans;
    }
}
