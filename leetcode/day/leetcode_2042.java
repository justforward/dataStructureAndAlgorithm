package leetcode.day;

/*
    处理string 里面的数字，然后判断是否单调递增
 */
public class leetcode_2042 {
    public static void main(String[] args) {
        leetcode_2042 leetcode_2042 = new leetcode_2042();
        String s = "hello world 5 x 5";
        System.out.println(leetcode_2042.areNumbersAscending(s));
    }

    public boolean areNumbersAscending(String s) {
        String[] s1 = s.split(" ");
        int pre = -1;
        for (String cur : s1) {
            // 判断当前是否是数字,true 是数字
            if (isNumericZidai(cur)) {
                int i = Integer.parseInt(cur);
                if (i <= pre) {
                    return false;
                }
                pre = i;
            }
        }
        return true;
    }

    public static boolean isNumericZidai(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
