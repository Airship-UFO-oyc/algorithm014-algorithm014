package _2020._08._31;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 46. 全排列
 * ----------------------------
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * ------------------------------------------------------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ------------------------------------------------------------------------------------------
 */
public class _01_0046_Permutations {


    //[1]深度优先遍历+回溯
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> results = new ArrayList<>();
        if (0 == len) return results;
        Deque<Integer> path = new ArrayDeque<>();//暂存遍历路径.sd
        boolean[] used = new boolean[len];//记录元素使用状态.
        dfs(nums, len, 0, path, used, results);//深度优先遍历
        return results;
    }

    private void dfs(int[] nums, int len, int level, Deque<Integer> path, boolean[] used, List<List<Integer>> results) {
        if (len == level) {//递归退出条件
            results.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) continue;//跳到下个未被使用的元素
            path.addLast(nums[i]);
            used[i] = true;//标记为被使用
            dfs(nums, len, level + 1, path, used, results);
            //回溯：所有操作回退
            path.removeLast();
            used[i]=false;
        }
    }


    public static void main(String args[]) {
        int[] nums = {1, 2, 3};
        System.out.println(new _01_0046_Permutations().permute(nums));
    }

}

