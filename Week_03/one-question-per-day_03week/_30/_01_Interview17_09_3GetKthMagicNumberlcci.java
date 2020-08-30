package _2020._08._30;

/**
 * 面试题 17.09. 第 k 个数
 * ----------------------------
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 * 示例 1:
 * 输入: k = 5
 * 输出: 9
 * --------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/get-kth-magic-number-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ------------------------------------------------------------------------------------------
 */
public class _01_Interview17_09_3GetKthMagicNumberlcci {

    /*
     * 核心思想：下一个数值，总是由上一个数值*3或5或7得到的，因此考虑三个数列：
     * 1、dp[0]*3,dp[1]*3,dp[2]*3,...
     * 2、dp[0]*5,dp[1]*5,dp[2]*5,...
     * 3、dp[0]*7,dp[1]*7,dp[2]*7,...
     * 将上面按照从小到大，合并到一起即可，如何做到这点，则需要设置三个指针，每个指针指向那种类型的最小值即可.
     * 初始状态：p3=0,p5=0,p7=0
     * dp[1] = Min(dp[p3]*3, dp[p5]*5, dp[p7]*7)
     *    Min(1*3, 1*5, 1*7)
     *    dp[1] = 3
     *    因此p3后移，即p3++，p3=1
     * dp[2] = Min(dp[p3]*3, dp[p5]*5, dp[7]*7)
     *    Min(3*3, 1*5, 1*7)
     *    dp[2] = 5
     *    因此p5后移，p5++，p5=1
     * dp[3] = Min(dp[p3]*3, dp[p5]*5, dp[p7]*7)
     *    Min(3*3, 3*5, 1*7)
     *    dp[3]=7
     *    因此p7后移，即p7++，p7=1
     * */
    //[1]三指针+动态规划
    public int getKthMagicNumber(int k) {
        int dp[] = new int[k];
        int p3 = 0, p5 = 0, p7 = 0;
        dp[0] = 1;
        for (int i = 1; i < k; i++) {
            dp[i] = Math.min(Math.min(dp[p3] * 3, dp[p5] * 5), dp[p7] * 7);//找到最小值
            if (dp[i] == dp[p3] * 3) p3++;//如果当前值与某类指针指向的值相同，则后移指针【每轮三个if判断必须都执行，防止排列组合之后是重复的值】.
            if (dp[i] == dp[p5] * 5) p5++;
            if (dp[i] == dp[p7] * 7) p7++;
        }
        return dp[k - 1];
    }


    public static void main(String args[]) {
        int k = 5;
        System.out.println(new _01_Interview17_09_3GetKthMagicNumberlcci().getKthMagicNumber(k));
    }

}

