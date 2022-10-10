package leetcode.interview;

/**
 * @author tandi
 * @date 2022/10/9 10:18 下午
 */
public class i_01_06_2 {
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
            return stringBuilder.toString().length() >= S.length() ? S : stringBuilder.toString();
        }


}
