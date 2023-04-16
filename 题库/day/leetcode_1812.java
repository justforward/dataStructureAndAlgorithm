package 题库.day;


/*
    根据x轴的坐标进行判断
 */
public class leetcode_1812 {
    public static void main(String[] args) {
        leetcode_1812 leetcode_1812 = new leetcode_1812();
        System.out.println(leetcode_1812.squareIsWhite("c7"));
    }

    public boolean squareIsWhite(String coordinates) {
        int x = coordinates.charAt(0) - 'a';
        int y = coordinates.charAt(1) - '0';

        if (x % 2 == 0) {
            if (y % 2 == 0) return true;
            else return false;
        } else {
            if (y % 2 == 0) return false;
            else return true;
        }
    }
}
