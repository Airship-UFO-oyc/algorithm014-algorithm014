package _2020._08._19._59_1;

import java.util.Arrays;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * ----------------------------
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * -------------------------------------------
 * 提示：
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 * 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
 * -------------------------------------------------------------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ------------------------------------------------------------------------------------------
 */
public class HuaDongChuangKouDeZuiDaZhilcof {


    //[1]暴力法：两层循环.
    static public int[] maxSlidingWindow(int[] nums, int k) {
        if (null == nums || 0 == nums.length) {
            return new int[0];
        }
        int[] reuslts = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int tempMax = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                if (nums[j] > tempMax) {
                    tempMax = nums[j];
                }
            }
            reuslts[i] = tempMax;
        }
        return reuslts;
    }

    public static void main(String args[]) {
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        int[] nums2 = {1, 3, -1};
        int k2 = 2;
        System.out.println(Arrays.toString(maxSlidingWindow(nums1, k1)));
        System.out.println(Arrays.toString(maxSlidingWindow(nums2, k2)));

    }


}

