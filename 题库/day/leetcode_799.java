package 题库.day;

/*
    每次都是前一个数的翻转
    每行数的个数是2*(n-1) 次幂
    查看需要找的数在每行的前半部分还是后半部分。

    n行的前半部分由n-1行相同 求上一行的数字，以此往上推

 */
public class leetcode_799 {
    public int kthGrammar(int n, int k) {
        if (k == 1) {
            return 0;
        }

        // 如果对应的k值在 位运算 求 2的次幂 如果在左边，需要进行取反
        // 否则是找到后面的相对位置
        if (k > (1 << (n - 2))) {
            // 取反
            return 1 ^ kthGrammar(n - 1, k - (1 << (n - 2)));
        }

        // 下一行的k所在位置？ 直接是前半段
        return kthGrammar(n - 1, k);
    }

    public static void main(String[] args) {
        int n = 5;
       System.out.println(1<<2);
    }
}
