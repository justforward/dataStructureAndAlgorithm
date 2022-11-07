package leetcode.weekend;

import java.util.*;

public class train_318 {
    public static void main(String[] args) {
        train_318 train_318 = new train_318();
//        int[] nums = new int[]{1, 2, 2, 1, 1, 0};
//        train_318.applyOperations(nums);
//        int[] nums = new int[]{1, 5, 4, 2, 9, 9, 9};
//        int k = 3;
//        System.out.println(train_318.maximumSubarraySum(nums, k));

        int[] costs = new int[]{17, 12, 10, 2, 7, 2, 11, 20, 8};
        int k = 3, candidates = 4;
        System.out.println(train_318.totalCost(costs, k, candidates));
    }


    // 第一题
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ArrayList<Integer> res_zero = new ArrayList<>();
        ArrayList<Integer> res_other = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();


        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = 2 * nums[i];
                nums[i + 1] = 0;
            }
        }

        for (int num : nums) {
            if (num == 0) {
                res_zero.add(num);
            } else {
                res_other.add(num);
            }
        }

        tmp.addAll(res_other);
        tmp.addAll(res_zero);
        for (int i = 0; i < n; i++) {
            ans[i] = tmp.get(i);
        }

        return ans;
    }

    // 第二题 单调栈

    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int index = 0;
        int ans = 0;
        int res = 0;
        while (index < n) {
            int cur = nums[index];
            while ((!queue.isEmpty() && hashMap.containsKey(cur)) || queue.size() == k) {
                Integer poll = queue.poll();
                if (hashMap.get(poll) == 1) {
                    hashMap.remove(poll);
                } else {
                    hashMap.put(poll, hashMap.get(poll) - 1);
                }
                res -= poll;
            }

            res += cur;
            queue.add(cur);
            hashMap.put(cur, hashMap.getOrDefault(cur, 0) + 1);
            index++;

            if (queue.size() == k) {
                ans = Math.max(res, ans);
            }
        }

        return ans;

    }

    // 第三题

    public long totalCost(int[] costs, int k, int candidates) {
        int ans = 0;
        PriorityQueue<int[]> queue_left = new PriorityQueue<int[]>(candidates,
                new Comparator<int[]>() {
                    public int compare(int[] p1, int[] p2) {
                        return p1[0] - p2[0];
                    }
                });

        PriorityQueue<int[]> queue_right = new PriorityQueue<int[]>(candidates,
                new Comparator<int[]>() {
                    public int compare(int[] p1, int[] p2) {
                        return p1[0] - p2[0];
                    }
                });

        int left = 0;
        int right = costs.length - 1;
        while (left < candidates && left < costs.length - 1) {
            queue_left.add(new int[]{costs[left], left});
            left++;
        }

        while (costs.length - right <= candidates && right >= 0) {
            queue_right.add(new int[]{costs[right], right});
            right--;
        }

        for (int i = 0; i < k; i++) {
            int[] poll_left = queue_left.peek();
            int[] poll_right = queue_right.peek();

            if (poll_left[0] == poll_right[0]) {
                ans += poll_left[0];
                // 查看下标相等
                if (poll_left[1] == poll_right[1]) {
                    queue_right.poll();
                }
                queue_left.poll();
                left++;
                if (left < costs.length) {
                    queue_left.offer(new int[]{costs[left], left});
                }
            } else if (poll_left[0] > poll_right[0]) {
                // 弹出右边
                ans += poll_right[0];
                queue_right.poll();
                right--;
                if (right >= 0) {
                    queue_right.add(new int[]{costs[right], right});
                }
            } else if (poll_left[0] == poll_right[0]) {
                // 弹出右边
                ans += poll_left[0];
                queue_left.poll();
                left--;
                if (left < costs.length) {
                    queue_left.add(new int[]{costs[left], left});
                }
            }
        }

        return ans;
    }

    //第四题
}
