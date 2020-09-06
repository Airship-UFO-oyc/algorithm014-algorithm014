package _2020._09._01;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 509. 斐波那契数
 * ----------------------------
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 * --------
 * 示例 1：
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 * ----------
 * 示例 2：
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 * ------------
 * 示例 3：
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 * -------------
 * 提示：
 * 0 ≤ N ≤ 30
 * -------------------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fibonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ------------------------------------------------------------------------------------------
 */
public class _01_0509_FibonacciNumber {


//    //[1]非递归
//    public int fib(int N) {
//        if (N < 2) return N;
//        int result = 0;
//        int n1 = 0;
//        int n2 = 1;
//        for (int i = 2; i <= N; i++) {
//            result = n1 + n2;
//            n1 = n2;
//            n2 = result;
//        }
//        return result;
//    }

    //[2]打表法
    //声明一个长度为31的数组，因为0<=N<=30
    List<Integer> array = new ArrayList<Integer>();
    {
        int result = 0;
        int n1 = 0;
        int n2 = 1;
        array.add(n1);
        array.add(n2);
        for (int i = 2; i <= 30; i++) {
            result = n1 + n2;
            array.add(result);
            n1 = n2;
            n2 = result;
        }
    }
    public int fib(int N) {
        return array.get(N);
    }

    public static void main(String args[]) {
        int n0 = 0;
        int n1 = 1;
        int n2 = 2;
        int n3 = 4;
        int n4 = 30;
        System.out.println(new _01_0509_FibonacciNumber().fib(n0));
        System.out.println(new _01_0509_FibonacciNumber().fib(n1));
        System.out.println(new _01_0509_FibonacciNumber().fib(n2));
        System.out.println(new _01_0509_FibonacciNumber().fib(n3));
        System.out.println(new _01_0509_FibonacciNumber().fib(n4));
    }

}

