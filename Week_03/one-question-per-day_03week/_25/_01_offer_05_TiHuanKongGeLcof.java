package _2020._08._25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 剑指 Offer 05. 替换空格
 * ----------------------------
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * 限制：
 * 0 <= s 的长度 <= 10000
 * -------------------------------------------------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ------------------------------------------------------------------------------------------
 */
public class _01_offer_05_TiHuanKongGeLcof {

//    //[1]暴力
//    static public String replaceSpace(String s) {
//        if (null == s || "" == s) return s;
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            sb.append(s.charAt(i) == ' ' ? "%20" : s.charAt(i));
//        }
//        return sb.toString();
//    }

//    //[2]使用内置函数
//    static public String replaceSpace(String s) {
//        return s.replaceAll(" ","%20");
//    }

    //[3]使用数组
    static public String replaceSpace(String s) {
        if (null == s || "" == s) return s;
        StringBuilder sb = new StringBuilder();
        char[] strs = new char[s.length() * 3];
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                strs[size++] = '%';
                strs[size++] = '2';
                strs[size++] = '0';
            } else {
                strs[size++] = s.charAt(i);
            }
        }
        return new String(strs, 0, size);
    }


    public static void main(String args[]) {
        System.out.println(replaceSpace("We are happy."));
    }

}

