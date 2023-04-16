package 题库.offer.E回文;


/*
    前提：都是小写字母

    1）双指针
    2）string 切分 左闭右开 s.substring(left,right) [left,right)
 */
public class offer_019 {
    public static void main(String[] args) {
        offer_019 offer_019 = new offer_019();
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        System.out.println(offer_019.validPalindrome(s));
    }

    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return valid(s.substring(left + 1, right + 1)) || valid(s.substring(left, right));
            }
            left++;
            right--;
        }
        return true;

    }


    public boolean valid(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
