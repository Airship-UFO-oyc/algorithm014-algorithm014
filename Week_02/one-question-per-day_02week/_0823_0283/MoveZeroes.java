package _2020._08._23._0283;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 283. 移动零
 * ----------------------------
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * -----------------------------------------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ------------------------------------------------------------------------------------------
 */
public class MoveZeroes {

    //[1]双指针方法
    static public void moveZeroes(int[] nums) {
        int lastNonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (0 != nums[i]) nums[lastNonZeroIndex++] = nums[i];
        }
        for (int i = lastNonZeroIndex; i < nums.length; i++) {//消除剩余非0
            nums[i] = 0;
        }
    }

    public static void main(String args[]) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}

