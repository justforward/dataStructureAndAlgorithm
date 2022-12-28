package leetcode.day;


/*
    根据操作直接去除首尾相同的连续字符即可，直到首尾字符不相等或者相交时停止

 */
public class leetcode_1750 {
    public static void main(String[] args) {
        leetcode_1750 leetcode_1750 = new leetcode_1750();
        int ans = leetcode_1750.minimumLength("aaa");
        System.out.println(ans);
    }

    public int minimumLength(String s) {
        int len = s.length();
        int left = 0, right = len - 1;
        while (left < right && s.charAt(left) == s.charAt(right)) {
            if(s.charAt(left)==s.charAt(right)){
                char same = s.charAt(left);
                // aaa 一直删除到left<right 保证可以删除完成
                while (left <= right && s.charAt(left) == same) left++;
                while (left <= right && s.charAt(right) == same) right--;
            }

        }
        return right - left + 1;
    }
}
