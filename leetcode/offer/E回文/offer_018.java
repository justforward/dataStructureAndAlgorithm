package leetcode.offer.E回文;


/*
    题目：包含字母和数字
    1）双指针
    2）判断字符是否是大小写
    3）将字符转成小写
 */
public class offer_018 {
    public static void main(String[] args) {
        offer_018 offer_018 = new offer_018();
        String s = "OP";
        System.out.println(offer_018.isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        // 双指针
        int left = 0, right = s.length() - 1;
        while (left < right) {
            // 判断当前字母是否是大小写字母
            while (!Character.isLetterOrDigit(s.charAt(left)) && left < right) {
                left++;
            }

            while (!Character.isLetterOrDigit(s.charAt(right)) && left < right) {
                right--;
            }

            if (left < right) {
                System.out.println(s.charAt(left));
                System.out.println(s.charAt(right));
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
            }

            left++;
            right--;
        }

        return true;
    }

    /*
        得到不同的
     */
    public boolean isWorld(char cur) {
        return (Character.isLowerCase(cur) || Character.isUpperCase(cur));
    }


}
