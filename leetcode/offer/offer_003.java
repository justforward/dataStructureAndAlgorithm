package leetcode.offer;

/*

    1) 使用n*(32)的做法
        求出每个num的1的个数，使用& 求1
    2）使用动态规划：由前一位来推导出后一位

      不失一般性的，假设当前我要统计的数的 i，i 对应的二进制表示是 00000...0010100101（共 32 位）
      如果我们是使用「朴素解法」求解的话，无论是从高位进行统计，还是从低位进行统计，最后一位扫描的都是边缘的数（如果是 1 就计数，不是 1 就不计数）

       从高位到低位,最后一步在扫描最低位之前，统计出 1 的个数应该等同于将 i 右移一位，
       并在最高位补 0，也就是等于 ans[i >> 1]，这时候就要求我们在计算 i 的时候 i >> 1 已经被算出来（从小到大遍历）

        在最高位补上0的数据 然后等于

 */
public class offer_003 {
    public static void main(String[] args) {
        offer_003 offer_003 = new offer_003();
        offer_003.countBits_one(2);
    }

    public int[] countBits_two(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

    public int[] countBits_one(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int oneNum = getOneNum(i);
            res[i] = oneNum;
        }

        return res;
    }


    public int getOneNum(int n) {
        int res = 0;
        while (n != 0) {
            n &= (n - 1);
            res++;
        }
        return res;
    }
}
