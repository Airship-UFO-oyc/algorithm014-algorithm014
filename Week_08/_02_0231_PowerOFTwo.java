package homework._08week;

/**
 * 231. 2的幂
 * ----------------------------
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * ---
 * 示例 1:
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * ---
 * 示例 2:
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * ---
 * 示例 3:
 * 输入: 218
 * 输出: false
 * -------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ------------------------------------------------------------------------------------------
 */
public class _02_0231_PowerOFTwo {


    //[1]思想：n二进制最高位为1，其余所有位为0；n-1对应n的最高位置是0，其余低位为1.
    //疑惑：此处有负数情况，题解中看到排除负数，但没有说明原因？
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }

    public static void main(String args[]) {
        int n1 = -2147483648;
        System.out.println(new _02_0231_PowerOFTwo().isPowerOfTwo(n1));
    }

}

