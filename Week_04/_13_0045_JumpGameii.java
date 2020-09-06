package homework._04week;

/**
 * 45. 跳跃游戏 II
 * ----------------------------
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * ------------------------
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 * 假设你总是可以到达数组的最后一个位置。
 * --------------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ------------------------------------------------------------------------------------------
 */
public class _13_0045_JumpGameii {


    //[1]贪心：正序
    public int jump(int[] nums) {
        int maxJump = 0;
        int count = 0;
        int end = 0;//边界
        for (int i = 0; i < nums.length - 1; i++) {//排除最后一个位置（因为一定能达到，因此最后一个位置不必作为起点去计算）
            maxJump = Math.max(maxJump, nums[i] + i);
            if (i == end) {
                end = maxJump;//下一次的边界
                count++;//跳跃的次数.
            }
        }
        return count;
    }


    public static void main(String args[]) {
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(new _13_0045_JumpGameii().jump(nums1));
    }

}

