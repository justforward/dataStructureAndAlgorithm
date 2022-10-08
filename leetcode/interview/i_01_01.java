package leetcode.interview;


/**
 * @author
 * 思路：
 *  1） hash 额外的数据结构
 *  2） 位运算
 *      2.1）使用二进制表示某个小写字母：
 *              首先计算出字符char离'a'这个字符的距离，
 *              即我们要位移的距离，用move_bit表示，
 *              那么使用左移运算符1 << move_bit则可以得到对应下标为1，其余下标为0的数，、
 *              如字符char = 'c'，则得到的数为000...00100
 *      2.2）使用&运算：判断是否在当前某个位置上出现重复的位
 *           将这个数跟mark做&（与）运算，
 *           由于这个数只有一个位为1，其他位为0，
 *           那么与运算的结果中，其他位肯定是0，
 *           而对应的下标位是否0则取决于之前这个字符有没有出现过，
 *           若出现过则被标记为1，那么与运算的结果就不为0；
 *           若之前没有出现过，则对应位的与运算的结果也是0，那么整个结果也为0。
 *      2.3）使用|（或）运算：记录当前位的1
 *           对于没有出现过的字符，我们用或运算mark | (1 << move_bit)将对应下标位的值置为1。
 *
 */
public class i_01_01 {
    public static void main(String[] args) {
        System.out.println('c' - 'a');
        System.out.println(1 << 2);

//        String s = "iluhwpyk";
//        i_01_01 i = new i_01_01();
//        System.out.println(i.isUnique(s));
    }

    public boolean isUnique(String astr) {
        // 当前的值
        int sum = 0;
        for (int i = 0; i < astr.length(); i++) {
            // 如果两个位出现不等于0的情况 说明出现了相同位，那么直接返回false
            if ((sum & (1 << (astr.charAt(i) - 'a'))) != 0) {
                return false;
            } else {
                // 否则需要记录这个位包含的数
                sum |= (1 << (astr.charAt(i) - 'a'));
            }
        }
        return true;

    }
}
