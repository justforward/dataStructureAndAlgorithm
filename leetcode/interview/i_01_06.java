package leetcode.interview;

/*

 */

public class i_01_06 {
    public static void main(String[] args) {
        i_01_06 i_01_06 = new i_01_06();
        System.out.println(i_01_06.compressString("abbccd"));
    }

    public String compressString(String S) {
        int left = 0, right = 0, len = S.length();
        StringBuilder stringBuilder = new StringBuilder();
        while (left < len && right < len) {
            if (S.charAt(left) == S.charAt(right)) {
                right++;
            } else {
                stringBuilder.append(S.charAt(left)).append(right - left);
                left = right;
            }
        }

        if (left < len) {
            stringBuilder.append(S.charAt(left)).append(right - left);
        }


        return stringBuilder.toString().length() > S.length() ? S : stringBuilder.toString();
    }
}
