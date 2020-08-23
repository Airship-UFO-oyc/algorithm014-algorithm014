package homework._02week;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * ----------------------------
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 提示：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 * ----------------------------------------------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0347_TopKFrequentElements {


    //方案一：使用优先队列
    static public int[] topKFrequent(int[] nums, int k) {
        int[] results = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int key : nums) {//初始化统计所有数字个数
            map.put(key, map.getOrDefault(key, 0) + 1);//如果没有获取到key，则设置为1.
        }
        //按照Map的降序设置优先队列：模拟大根堆.
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> temp = maxHeap.poll();//获取顶部数据，并移除.
            results[i] = temp.getKey();
        }
        return results;
    }


    public static void main(String args[]) {
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        System.out.println(Arrays.toString(topKFrequent(nums1, k1)));
        int[] nums2 = {1};
        int k2 = 1;
        System.out.println(Arrays.toString(topKFrequent(nums2, k2)));
    }
}