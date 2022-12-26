package leetcode.day;

import java.util.ArrayList;
import java.util.List;

public class leetcode_1703 {


    //
    public int minMoves(int[] nums, int k) {
        List<Integer> zeros = new ArrayList<>();
        int z = 0;
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] == 1){
                i++;
                break;
            }
        }
        for (; i < nums.length; i++) {
            if (nums[i] == 1){
                zeros.add(z);
                z = 0;
            }else {
                z++;
            }
        }
        int cost = 0;
        for (int j = 0; j < k-1; j++) {
            cost += zeros.get(j)*Math.min(j+1, k-j-1);
        }
        int[] pre = new int[zeros.size()+1];
        // 前缀和
        for (int j = 1; j <= zeros.size(); j++) {
            pre[j] += zeros.get(j-1)+pre[j-1];
        }
        int temp = cost;
        for (int j = k-1; j < zeros.size(); j++) {
            temp -= pre[k/2+(j-k+1)]-pre[j-k+1];
            temp += pre[j+1]-pre[k/2+(j-k+1)+k%2];
            cost = Math.min(temp, cost);
        }
        return cost;
    }
}
