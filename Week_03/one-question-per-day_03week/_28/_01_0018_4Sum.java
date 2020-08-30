package _2020._08._28;

import java.text.NumberFormat;
import java.util.*;

/**
 * 18. 四数之和
 * ----------------------------
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 注意：
 * 答案中不可以包含重复的四元组。
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * -----------------------------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ------------------------------------------------------------------------------------------
 */
public class _01_0018_4Sum {

    //[1]排序+剪枝+双指针
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result; //去掉不满足条件
        Arrays.sort(nums);//排序
        int length = nums.length;
        //定义4个指针k，i，j，h  k从0开始遍历，i从k+1开始遍历，留下j和h，j指向i+1，h指向数组最大值
        //第一层
        for (int k = 0; k < length - 3; k++) {
            if (target >= 0 && nums[k] > target) break;//如果target为大于等于0的数时，最小数值大于target，直接终止。
            if (k > 0 && nums[k] == nums[k - 1]) continue;//去掉重复数值
            int min1 = nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3];
            if (min1 > target) break;//计算最小值，如果最小值还大于target，说明后面越来越大，则没有必要继续，终止！
            int max1 = nums[k] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if (max1 < target) continue;//计算最大值，如果最大值还小于target，说明对于当前i，后面越来越小，则没有必要继续，本次终止！
            //第二层循环i，初始值指向k+1
            for (int i = k + 1; i < length - 2; i++) {
                if (i > k + 1 && nums[i] == nums[i - 1]) continue;//去掉重复数值
                int j = i + 1;//定义指针j指向i+1
                int h = length - 1;//定义指针h指向数组末尾
                int min = nums[k] + nums[i] + nums[j] + nums[j + 1];
                if (min > target) break; //计算最小值，如果最小值还大于target，说明后面越来越大，则没有必要继续，终止！
                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
                int max = nums[k] + nums[i] + nums[h] + nums[h - 1];
                if (max < target) continue;//计算最大值，如果最大值还小于target，说明对于当前i，后面越来越小，则没有必要继续，本次终止！
                ///开始j指针和h指针的表演，计算当前和，如果等于目标值，j++并去重，h--并去重，当当前和大于目标值时h--，当当前和小于目标值时j++
                while (j < h) {
                    int current = nums[k] + nums[i] + nums[j] + nums[h];
                    if (current == target) {
                        result.add(Arrays.asList(nums[k], nums[i], nums[j], nums[h]));
                        j++;
                        while (j < h && nums[j] == nums[j - 1]) j++;//去掉重复数据
                        h--;
                        while (j < h && i < h && nums[h] == nums[h + 1]) h--;//去掉重复数据
                    } else if (current > target) {
                        h--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return result;
    }


    public static void main(String args[]) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(new _01_0018_4Sum().fourSum(nums, target).toString());
        int[] nums2 = {1,-2,-5,-4,-3,3,3,5};
        int target2 = -11;
        System.out.println(new _01_0018_4Sum().fourSum(nums2, target2).toString());
    }

}

