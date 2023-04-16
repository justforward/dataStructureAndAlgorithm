package 题库.offer.M二分;

/*
    题目：数组中只有一个元素出现一次，其余的元素出现两次。
    思路：
        解法一：对数组中的元素进行异或操作，剩下的那个元素就是出现一次的元素。o(n)
        解法二：根据数组的下标奇偶进行查看，由于给定数组有序 且 常规元素总是两两出现，
              因此如果不考虑“特殊”的单一元素的话，
              我们有结论：成对元素中的第一个所对应的下标必然是偶数，成对元素中的第二个所对应的下标必然是奇数。

              然后再考虑存在单一元素的情况，假如单一元素所在的下标为 xx，
              那么下标 xx 之前（左边）的位置仍满足上述结论，
              而下标 xx 之后（右边）的位置由于 xx 的插入，导致结论翻转。

            这里要进行一些判断：
             如果 mid 本身是偶数，那么 mid + 1 就是奇数；
             如果 mid 本身是奇数，那么 mid - 1 就是偶数。

             这两种情况，我们可以使用异或来进行统一，因为 偶数异或1 等于 加1，奇数异或1 等于 减1。

 */
public class offer_070 {

//    public int singleNonDuplicate(int[] nums) {
//        int left = 0, right = nums.length - 1;
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (mid % 2 == 0) { // 下标是偶数
//                if (nums[mid] == nums[mid + 1]) { // 如果和后一个数相等，说明乱序的在后面
//                    left = mid + 2; // left 跳过相等的那个
//                } else { // 可能mid就是那个数字？ 否则在前面
//                    right = mid;
//                }
//            } else { // 下标是奇数
//                if (nums[mid] == nums[mid - 1]) { //如果和前一个值相等，说明乱序的位置在后面
//                    left = mid + 1;// 跳过当前的数
//                } else {// mid 可能是那个数字
//                    right = mid;
//                }
//            }
//
//        }
//        return nums[right];
//    }

    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        // 在left==right的时候停止下来
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 如果是偶数
            if (mid % 2 == 0) {
                // 查看后一个值跟当前是否相等
                if (nums[mid] == nums[mid + 1]) {
                    // 说明这个乱序的在后面
                    left = mid + 2;
                } else {
                    // 乱序在前面  可能mid就是那个值
                    right = mid;
                }
            } else {// 奇数
                //查看前一个值与当前是否相等
                if (nums[mid] == nums[mid - 1]) {
                    // 说明乱序在后面
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        // 输出right和left都一样
        return nums[right];

    }
}
