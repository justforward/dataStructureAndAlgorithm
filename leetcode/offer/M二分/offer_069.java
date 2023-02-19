package leetcode.offer.M二分;

/*
    一定存在峰值？【left,mid,right】
 */
public class offer_069 {

//    public int peakIndexInMountainArray(int[] arr) {
//        int left = 0, right = arr.length - 1;
//        int mid = 0;
//        while (left <= right) { //break 的前提 由于这个值一定存在峰值，这个可以忽略
//            mid = left + (right - left) / 2;
//            if (arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid]) {
//                // 说明这个点是峰值
//                break;
//            }
//            // 如果前一个值大于mid 说明峰值在右边
//            if (arr[mid + 1] > arr[mid]) left = mid;
//            // 如果前一个值小于mid，说明峰值在左边
//            if (arr[mid + 1] < arr[mid]) right = mid;
//        }
//        return mid;
//    }


    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                break;
            }
            if (arr[mid] < arr[mid + 1]) {
                left = mid;
            }
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            }
        }

        return mid;

    }


}
