package _2020._08._20._0412;

import java.util.*;

/**
 * 412. Fizz Buzz
 * ----------------------------
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 * 示例：
 * n = 15,
 * 返回:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 * ------------------------------------------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fizz-buzz
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ------------------------------------------------------------------------------------------
 */
public class FizzBuzz {


    //[1]暴力法
//    static public List<String> fizzBuzz(int n) {
//        List<String> results = new ArrayList<>();
//        for (int i = 1; i <= n; i++) {
//            if (i % 15 == 0) {
//                results.add("FizzBuzz");
//            } else if (i % 3 == 0) {
//                results.add("Fizz");
//            } else if (i % 5 == 0) {
//                results.add("Buzz");
//            } else {
//                results.add(i + "");
//            }
//        }
//        return results;
//    }

    //[2]分类打表法：分类使用集合记录，提前计算各个数值的倍数集合。
//    static public List<String> fizzBuzz(int n) {
//        List<String> results = new ArrayList<>();
//        Set<Integer> _3Set = new HashSet<>();
//        Set<Integer> _5Set = new HashSet<>();
//        Set<Integer> _15Set = new HashSet<>();
//        //计算机更适合做加法运算.
//        for (int i = 3; i <= n; i += 3) _3Set.add(i);
//        for (int i = 5; i <= n; i += 5) _5Set.add(i);
//        for (int i = 15; i <= n; i += 15) _15Set.add(i);
//        for (int i = 1; i <= n; i++) {
//            if (_15Set.contains(i)) results.add("FizzBuzz");
//            else if (_3Set.contains(i)) results.add("Fizz");
//            else if (_5Set.contains(i)) results.add("Buzz");
//            else results.add(i + "");
//        }
//        return results;
//    }

    static Set<Integer> _3Set = new HashSet<>();
    static Set<Integer> _5Set = new HashSet<>();
    static Set<Integer> _15Set = new HashSet<>();
    static int historyMax = 0;//历史最大值

    //[3]暂存历史的分类打表法：分类使用集合记录，提前计算各个数值的倍数集合。
    static public List<String> fizzBuzz(int n) {
        List<String> results = new ArrayList<>();
        if (historyMax < n) {
            //计算机更适合做加法运算.
            for (int i = historyMax + 3 - historyMax % 3; i <= n; i += 3) _3Set.add(i);
            for (int i = historyMax + 5 - historyMax % 5; i <= n; i += 5) _5Set.add(i);
            for (int i = historyMax + 15 - historyMax % 15; i <= n; i += 15) _15Set.add(i);
            historyMax = n;
        }
        for (int i = 1; i <= n; i++) {
            if (_15Set.contains(i)) results.add("FizzBuzz");
            else if (_3Set.contains(i)) results.add("Fizz");
            else if (_5Set.contains(i)) results.add("Buzz");
            else results.add(i + "");
        }
        return results;
    }




    public static void main(String args[]) {
        System.out.println(fizzBuzz(15));
        System.out.println("---------------------");
        System.out.println(fizzBuzz(20));

    }

}

