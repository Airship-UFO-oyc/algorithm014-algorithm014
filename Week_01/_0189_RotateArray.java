package _01week.homework;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 189. 旋转数组
 * ----------------------------
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * 示例 2:
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * --------------------------------------------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0189_RotateArray {

    //暴力法  时间复杂度：O(n*k)  空间复杂度：O(1)
//    static public void rotate(int[] nums, int k) {
//        k = k % nums.length; //如果移动次数超过数组长度，则对移动k值进行取模运算.
//        int tempValue;//临时存储的数值
//        for (int i = 0; i < k; i++) {
//            tempValue = nums[nums.length - 1];//取尾部数值
//            for (int j = nums.length - 1; j >0; j--) {
//                nums[j] = nums[j-1];
//            }
//            nums[0] = tempValue;
//        }
//    }

    //方案二：使用环状替换   时间复杂度：O(N) = k*(N/k)  空间复杂度：O(1)
    static public void rotate(int[] nums, int k) {
        k = k % nums.length; //如果移动次数超过数组长度，则对移动k值进行取模运算.
        int count = 0;
        //外层循环次数和内层循环有密切关系：count= (n%k)==0 ? N/k : N和k的最小公倍数/k
        //并且count最终是等于nums.length，也即是N。（跳出内部循环的count大最大值为N，也即是k和nums.length互为质数）
        for (int startIndex = 0; count < nums.length; startIndex++) {
            //缓存开始下标，开始下标和当前移动下标相同时跳出.
            int currentIndex = startIndex;
            int currentValue = nums[currentIndex];//当前的数值
            do {
                int nextIndex = (currentIndex + k) % nums.length;
                int nextValue = nums[nextIndex];
                nums[nextIndex] = currentValue;
                currentValue = nextValue;
                currentIndex = nextIndex;
                count++;
            } while (currentIndex != startIndex);
        }
    }

    public static void main(String args[]) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums1, 3);
        System.out.println(Arrays.toString(nums1));
        int[] nums2 = {-1, -100, 3, 99};
        rotate(nums2, 6);
        System.out.println(Arrays.toString(nums2));
        int[] nums3 = {-1, -100, 3, 99};
        rotate(nums3, 0);
        System.out.println(Arrays.toString(nums3));
        int[] nums4 = {1,2,3,4,5,6,7};
        rotate(nums4, 3);
        System.out.println(Arrays.toString(nums4));

    }
}
