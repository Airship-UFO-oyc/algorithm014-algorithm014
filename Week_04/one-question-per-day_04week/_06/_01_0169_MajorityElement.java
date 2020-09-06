package _2020._09._06;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 * ----------------------------
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * -----------------------------------------
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * -----------------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ------------------------------------------------------------------------------------------
 */
public class _01_0169_MajorityElement {


    //[1]排序+二分查找
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //[2]哈希表
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> elementMap = new HashMap<>();
        Integer majorityElement = 0;
        Integer majorityCount = 0;
        Integer maxCount = nums.length / 2;
        for (int num : nums) {
            if (elementMap.containsKey(num)) elementMap.put(num, elementMap.get(num) + 1);
            else elementMap.put(num, 1);
            Integer count = elementMap.get(num);
            if (majorityCount < count) {
                majorityElement = num;
                majorityCount = count;
            }
            if (majorityCount > maxCount) break;
        }
        return majorityElement;
    }

    //[3]摩尔投票法
    public int majorityElement(int[] nums) {
        int majority = 0;
        int count = 0;
        for (int num : nums) {
            if (0 == count) majority = num;
            count += (majority == num ? 1 : -1);
        }
        return majority;
    }

    public static void main(String args[]) {
        int[] nums1 = {3, 2, 3};
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(new _01_0169_MajorityElement().majorityElement(nums1));
        System.out.println(new _01_0169_MajorityElement().majorityElement(nums2));
    }

}


