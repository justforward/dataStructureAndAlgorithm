package leetcode.offer.B位运算;

/*
    两个单词是否有公共字符？

 */
public class offer_005 {
    public static void main(String[] args) {
        String[] words = new String[]{"abcw", "baz", "foo", "bar", "fxyz", "abcdef"};
        offer_005 offer_005 = new offer_005();
        offer_005.maxProduct(words);
    }

    public int maxProduct(String[] words) {
        // 可以将位运算预处理的 将字母设置为26位 得到相同的位上是否为1 进行|的方案
        // 记为第0 到第25个英文字母
        // 相同的字母在当前位上为1 当前位为1的时候，说明在这个序列上出现了相同的字母
        int len = words.length;
        int[] marks = new int[len];

        // 根据得到的位置
        for (int m = 0; m < words.length; m++) {
            for (int i = 0; i < words[m].length(); i++) {
                // 针对每一位进行数字的拼接？一直往对应的位上存放相关的值
                marks[m] |= 1 << ((words[m].charAt(i)) - 'a');
            }
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                // 判断是否存在重复的位数 &==0 说明 没有重复的位 两个位都为1的时候才是1 否则是0 当出现这个值的时候 说明这个值是
                if ((marks[i] & marks[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }


}
