package leetcode.offer;

/*
    得到每一位上的数字 相加 每次记录进位
 */
public class offer_002 {
    public static void main(String[] args) {

        offer_002 offer_002 = new offer_002();
        System.out.println(offer_002.addBinary("111", "1"));
    }

    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int m = a.length() - 1;
        int n = b.length() - 1;
        int forward = 0;
        while (m >= 0 && n >= 0) {
            int one = a.charAt(m) - '0';
            int two = b.charAt(n) - '0';
            int res = one + two + forward;
            stringBuilder.append(res % 2);
            forward = res / 2;
            m--;
            n--;
        }

        if (m >= 0 || n >= 0) {
            while (m >= 0) {
                int one = a.charAt(m) - '0';
                int res = one + forward;
                stringBuilder.append(res % 2);
                forward = res / 2;
                m--;
            }

            while (n >= 0) {
                int one = b.charAt(n) - '0';
                int res = one + forward;
                stringBuilder.append(res % 2);
                forward = res / 2;
                n--;
            }
        }

        if (forward == 1) {
            stringBuilder.append(forward);
        }


        return stringBuilder.reverse().toString();

    }

}
