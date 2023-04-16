package 题库.offer.G字符串;

/*
    hashmap 这个记录是否存在一样，异或求是否是0
 */
public class offer_032 {
    public static void main(String[] args) {
        String s = "nl", t = "cx";
        offer_032 offer_032 = new offer_032();
        System.out.println(offer_032.isAnagram(s, t));

        System.out.println(0 ^ 1);
    }

    // 顺序 记录位置
    public boolean isAnagram(String s, String t) {
        return true;
//        if (s.length() != t.length()) {
//            return false;
//        }
//        int[] s_array = new int[26];
//        int[] t_array = new int[26];
//        int tmp = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int s_index = s.charAt(i) - 'a';
//            s_array[s_index]++;
//
//            int t_index = t.charAt(i) - 'a';
//            t_array[t_index]++;
//
//            // 查看两个值的异或
//            tmp += (s_index ^ t_index);
//        }
//
//        int ans = 0;
//        for (int i = 0; i < s_array.length; i++) {
//            ans += (s_array[i] ^ t_array[i]);
//        }
//        return ans == 0 && tmp != 0;
    }
}
