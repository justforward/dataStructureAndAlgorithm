package leetcode.weekend;

/**
 * @author tandi
 * @date 2022/11/13 10:11 上午
 */
public class train_319 {


    // 第一题
    public double[] convertTemperature(double celsius) {
        double kai = celsius + 273.15;
        double hua = celsius * 1.80 + 32.00;
        return new double[]{kai, hua};
    }

    // 第二题

    public int getGcd(int m, int n) {
        while (n > 0) {
            int temp = m % n;
            m = n;
            n = temp;
        }
        return m;
    }

    //求解数m和n和最小公倍数
    public int getLcm(int m, int n) {
        int gcd = getGcd(m, n);
        int result = m * n / gcd;
        return result;
    }

    public int subarrayLCM(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        for (int l = 0; l < n; l++) {
            int g = nums[l];
            for (int r = l; r < n; r++) {
                g = getLcm(g, nums[r]);
                if (g == k) {
                    res++;
                }
            }
        }

        return res;
    }


    // 第三题
    public static void main(String[] args) {
        train_319 train_319 = new train_319();
        String s = "fttfjofpnpfydwdwdnns";
        int k = 2;
        System.out.println(train_319.maxPalindromes(s, k));
    }

    // 一直扩 满足找到一下
    public int maxPalindromes(String s, int k) {
        int ans = 0;
        if (s == null || s.length() == 0) {
            return ans;
        }
        int h = 0, t = 0;
        int i = 0;
        while (i < s.length()) {
            // 以字符作为中心点扩展
            int l1 = expand(s, i, i);
            int l2 = expand(s, i, i + 1);
            int pl = Math.max(l1, l2);
            if (pl > t - h) {
                h = i - (pl - 1) / 2;
                t = i + pl / 2;
                i = t + 1;
            } else {
                i++;
            }
            if (pl >= k) {
                ans++;
            }
        }

        return ans;
    }

    private int expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }


}
