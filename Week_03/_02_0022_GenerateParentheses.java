package homework._03week;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * ----------------------------
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例：
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * -----------------------------------------------------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _02_0022_GenerateParentheses {


    //[1]递归：递归+剪枝
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();//使用静态全局变量，会积累上次结果导致出错.
        helper(0, 0, n, "", results);
        return results;
    }

    private void helper(int left, int right, int n, String s, List<String> results) {
        if (left == n && right == n) {//递归出口
            results.add(s);
            return;
        }
        //处理//下一层
        if (left < n) helper(left + 1, right, n, s + "(", results);
        if (right < left) helper(left, right + 1, n, s + ")", results);
        //恢复现场
    }

    public static void main(String args[]) {
        System.out.println(new _02_0022_GenerateParentheses().generateParenthesis(1));
    }
}