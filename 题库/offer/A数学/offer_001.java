package 题库.offer.A数学;

/*
    除法 是用除数减去被除数，查看有几个存在的被除数的个数
    除法需要查看符号位，相同的符号为正，出现不同的符号位负

    // 因为将 -2147483648 转成正数会越界，但是将 2147483647 转成负数，则不会
    对于正数可以转成负数进行
 */
public class offer_001 {
    public static void main(String[] args) {
        offer_001 offer_001 = new offer_001();
        System.out.println(offer_001.divide(7, -2));
    }

    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) return Integer.MAX_VALUE;

        int sign = (a > 0) ^ (b > 0) ? 1 : -1;

        if (a > 0) a = -a;
        if (b > 0) b = -b;
        int res = 0;
        while (a <= b) {
            a -= b;
            res++;
        } // bug 修复：因为不能使用乘号，所以将乘号换成三目运算符
        return sign == 1 ? res : -res;
    }

}
