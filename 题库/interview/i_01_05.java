package 题库.interview;

/*
    只需要一次的编辑（插、删、替换）
    计算编辑距离
    1）假设first是需要操作的，second 是操作完成后的字符串
 */

public class i_01_05 {
    public static void main(String[] args) {
        String first = "spartan", second = "part";
        i_01_05 i = new i_01_05();
        System.out.println(i.oneEditAway(first, second));
    }

    public boolean oneEditAway(String first, String second) {
        int left_f = 0, left_s = 0;
        int diff_num = 0;
        int fl = first.length(), sl = second.length();
        if (Math.abs(fl - sl) > 1) {
            return false;
        }
        while (left_f < fl && left_s < sl) {
            if (first.charAt(left_f) == second.charAt(left_s)) {
                left_f++;
                left_s++;
            } else {
                diff_num++;
                if (diff_num > 1) return false;
                if (fl == sl) {
                    left_f++;
                    left_s++;
                } else if (fl > sl) {
                    left_f++;
                } else {
                    left_s++;
                }
            }
        }

        return true;
    }
}
