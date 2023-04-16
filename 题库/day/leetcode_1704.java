package 题库.day;


/*
    包含相同数目的元音数目
 */
public class leetcode_1704 {
    public static void main(String[] args) {
        leetcode_1704 leetcode_1704 = new leetcode_1704();
        String s = "textbook";
        System.out.println(leetcode_1704.halvesAreAlike(s));
    }

    public boolean halvesAreAlike(String s) {
        String container = "aeiouAEIOU";
        int left = 0, right = s.length() - 1;
        int num = 0;
        while (left <= right) {
            if (container.contains(String.valueOf(s.charAt(left)))) {
                num++;
            }
            if (container.contains(String.valueOf(s.charAt(right)))) {
                num--;
            }
            left++;
            right--;
        }
        return num == 0;
    }
}
