package _2020._09._05;

/**
 * 367. 有效的完全平方数
 * ----------------------------
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * ---------------------------------------
 * 示例 1：
 * 输入：16
 * 输出：True
 * --------------------------
 * 示例 2：
 * 输入：14
 * 输出：False
 * -------------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ------------------------------------------------------------------------------------------
 */
public class _01_0367_ValidPerfectSquare {


    //[1]二分查找
    public boolean isPerfectSquare1(int num) {
        if (1 == num) return true;
        int left = 2;
        int right = num / 2;
        int mid = 0;
        long square = 0;//可能会整型溢出，需要使用long
        while (left <= right) {
            mid = left + (right - left) / 2;
            square = (long) mid * mid;
            if (square == num) return true;
            else if (square > num) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }

    //[2]牛顿迭代法
    public boolean isPerfectSquare(int num) {
        if (1 == num) return true;
        int x = num / 2;//初始估算值
        long square = (long) x * x;//防止整型溢出
        while (square > num) {
            x = (x + num / x) / 2;//下一个解
            square = (long) x * x;
        }
        return square == num;
    }


    public static void main(String args[]) {
        System.out.println(new _01_0367_ValidPerfectSquare().isPerfectSquare(16));
        System.out.println(new _01_0367_ValidPerfectSquare().isPerfectSquare(808201));
        System.out.println(new _01_0367_ValidPerfectSquare().isPerfectSquare(2));
    }

}

