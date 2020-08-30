package homework._03week;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 70. 爬楼梯
 * ----------------------------
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * <p>
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * --------------------------------------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _01_0070_ClimbingStairs {

//    //[1]递归：无优化
//    static public int climbStairs(int n) {
//        if (n < 3) return n;//递归出口
//        //处理
//        //下一层
//        //恢复现场
//        return climbStairs(n - 1) + climbStairs(n - 2);
//    }


    //[2]非递归
    public int climbStairs(int n) {
        if (n < 3) return n;//递归出口
        int n1 = 1;
        int n2 = 2;
        int n3 = 0;
        for (int i = 3; i <= n; i++) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return n3;
    }


    public static void main(String args[]) {

        System.out.println(new _01_0070_ClimbingStairs().climbStairs(4));
    }
}