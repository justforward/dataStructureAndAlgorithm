package 题库.offer.K不常见数据结构;

import java.math.BigInteger;
import java.util.*;

/*
    优先队列： 最小堆的和相减
 */
public class offer_061 {
    public static void main(String[] args) {
        offer_061 offer_061 = new offer_061();
        int[] nums1 = new int[]{1, 1, 2}, nums2 = new int[]{1, 2, 3};
        int k = 10;
        offer_061.kSmallestPairs(nums1, nums2, k);
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new LinkedList<>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (nums1[o1[0]] + nums2[o1[1]]) - (nums1[o2[0]] + nums2[o2[1]]);
            }
        });

        for (int i = 0; i < nums1.length; i++) {
            // 将num2的下标从0开始存放
            priorityQueue.add(new int[]{i, 0});
        }

        while (k-- > 0 && !priorityQueue.isEmpty()) {
            int[] poll = priorityQueue.poll();
            ans.add(Arrays.asList(nums1[poll[0]], nums2[poll[1]]));
            // 这里统计的是数直接无法返回？需要统计下标可以
            if (++poll[1] < nums2.length) {
                priorityQueue.add(new int[]{poll[0], poll[1]});
            }
        }
        return ans;
    }


    private static final int d = 256; // radix of size alphabat
    private static int q; // we will use a random 31 bits of prime number
    private static int N; // length of string

    public String longestDupSubstring(String s) {
        // 使用31个字节的hash
        q = longRandomPrime();
        // N是string的长度
        N = s.length();
        int left = 0, right = N - 1;

        // binary search of length
        String res = "";
        while(left < right) {
            int mid = left + (right-left)/2;
            int k = mid+1;
            String dup = RabinKarp(s, k);
            if(!dup.equals("")) {
                res = dup;
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return res;
    }

    private String RabinKarp(String s, int k) {
        if(k == 0) {
            return "";
        }

        /*
        h == pow(d,k-1)%q, the highest position power.
        [h^0..h^k-1]
        */
        long h = 1;
        for(int i = 0;i < k-1;i++) {
            h = (h*d)%q;
        }

        // hash of first window
        long t = 0;
        for(int i = 0;i < k;i ++) {
            t = (d*t + s.charAt(i))%q;
        }

        // using map to check collision
        HashMap<Long, ArrayList<Integer>> map = new HashMap<>();
        map.put(t, new ArrayList<>(Arrays.asList(0))); // hash -> start

        /*
        sliding window,eg, rolling hash.
        [start, end)
        end - start = k => start = end - k
        [1..end)
        */
        for(int start = 1;start <= N - k;start++) {
            /*
            hash of new window using rolling hash, [0...k-1] => [start, start+k-1]
            remove leading, add trailing
            */
            char leading = s.charAt(start-1);
            char trailing = s.charAt(start+k-1);
            t = (d*(t - h*leading) + trailing)%q;
            if(t < 0) {
                // t maybe less than 0
                t = t+q;
            }

            ArrayList<Integer> list = map.get(t);
            if(list == null) {
                // just a new hash
                map.put(t, new ArrayList<>(Arrays.asList(start)));
            } else {
                // maybe a duplite since they have same hashes
                String cur = s.substring(start, start+k);
                for(int from: list) {
                    // 如果已经匹配这个值
                    if(cur.equals(s.substring(from, from+k))) {
                        return cur;
                    }
                }
                list.add(start);
            }
        }
        return "";
    }

    // get a random 31 bits of a prime number
    private static int longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.intValue();
        // return 10007;
    }

}
