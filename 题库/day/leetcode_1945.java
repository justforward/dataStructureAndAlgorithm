package 题库.day;


/*
    先将s转化成数字 然后进行查找
 */
public class leetcode_1945 {
    public static void main(String[] args) {
        leetcode_1945 leetcode_1945 = new leetcode_1945();
        String s = "iiii";
        int k = 1;
        System.out.println(leetcode_1945.getLucky(s, k));
    }

    public int getLucky(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - 'a' + 1;
            stringBuilder.append(cur);
        }

        String tmp = stringBuilder.toString();
        while (k > 0) {
            int tmpAns = 0;
            for (int i = 0; i < tmp.length(); i++) {
                tmpAns += tmp.charAt(i) - '0';
            }
            tmp = String.valueOf(tmpAns);
            k--;
        }

        return Integer.valueOf(tmp);
    }
}
