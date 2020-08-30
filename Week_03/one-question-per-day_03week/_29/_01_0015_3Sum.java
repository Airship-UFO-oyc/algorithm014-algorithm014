package _2020._08._29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * ----------------------------
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * ----------------------------------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ------------------------------------------------------------------------------------------
 */
public class _01_0015_3Sum {

    //[1]排序+剪枝+双指针
    static public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (null == nums || nums.length < 3) return results;//去掉不满足条件
        Arrays.sort(nums);//排序
        int target = 0;
        //定义3个指针i，j，high，i从0遍历，j指向i+1，h指向数组最大值
        //第一层循环
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > target) break;//最小数值大于target，直接终止
            if (i > 0 && nums[i] == nums[i - 1]) continue;//去掉重复数值
            int j = i + 1;
            int h = nums.length - 1;
            int min1 = nums[i] + nums[j] + nums[j + 1];
            if (min1 > target) break;//计算最小值，如果最小值还大于target，说明后面越来越大，则没有必要继续，终止！
            int max1 = nums[i] + nums[h] + nums[h - 1];
            if (max1 < target) continue;//计算最大值，如果最大值还小于target，说明对于当前i，后面越来越小，则没有必要继续，本次终止！
            //遍历三数值相加，有三种情况：1、与target相同，则记录，j++并去重，h--并去重；2、大于target，h--；3、小于target，j++。
            while (h > j) {
                int current = nums[i] + nums[j] + nums[h];
                if (current == target) {
                    results.add(Arrays.asList(nums[i], nums[j], nums[h]));
                    j++;
                    while (h > j && nums[j] == nums[j - 1]) {//去重
                        j++;
                    }
                    h--;
                    while (h > j && nums[h] == nums[h + 1]) {//去重
                        h--;
                    }
                } else if (current > target) {
                    h--;
                } else {
                    j++;
                }
            }
        }
        return results;
    }


    public static void main(String args[]) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums).toString());

//        //待测试数据
//        int i = 12;
//        //得到一个NumberFormat的实例
//        NumberFormat nf = NumberFormat.getInstance();
//        //设置是否使用分组
//        nf.setGroupingUsed(false);
//        //设置最大整数位数
//        nf.setMaximumIntegerDigits(10);
//        //设置最小整数位数
//        nf.setMinimumIntegerDigits(10);
//        //输出测试语句
//        System.out.println(nf.format(i));

//        int youNumber = 11;
//        // 0 代表前面补充0
//        // 4 代表长度为4
//        // d 代表参数为正数型
//        String str = String.format("%010d", youNumber);
//        System.out.println(str); // 0001

    }

}

