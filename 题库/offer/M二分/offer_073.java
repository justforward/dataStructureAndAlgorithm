package 题库.offer.M二分;

/**
 * @author tandi
 * @date 2023/2/20 下午9:37
 * 从1 到 max(piles[x]) 找到一个速度，通过这个速度/piles 的值 得到耗时，找到小于等于h的最小
 * 但是这个会过不了测试用例
 */
public class offer_073 {

    // 左闭右闭区间
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int l = 1, r = max;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // 得到花费的时间
            int s = 0;
            for (int pile : piles) {
                s += (pile - 1) / mid + 1; // 向上去整
            }
            // 如果耗时小于等于h 可以再小 r的右侧是耗时小于等于h的
            if (s <= h) r = mid - 1;
            // 耗时大的情况下 需要将s变大 l的左侧都是耗时大于h的
            else l = mid + 1;
        }
        return l;
    }

    // 左闭右开区间 最后不会溢出
    public int minEatingSpeed2(int[] piles, int h) {
        int max = 0;
        for(int pile : piles) { // 确定最大香蕉堆的香蕉根数
            max = Math.max(max, pile);
        }
        int l = 1, r = max;
        while(l < r){
            int hx = 0;
            int k = l + (r - l) / 2;
            for(int pile : piles) { // 求k对应的时间
                hx += (pile - 1) / k + 1; // 向上取整写法
            }
            if(hx <= h) r=k;  // 耗时多于h，要加快速度
            else l = k + 1; // 耗时小于等于h，降低速度
        }
        return l;
    }
}
