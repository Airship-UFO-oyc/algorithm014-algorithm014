package _2020._08._17._0350;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 350. 两个数组的交集 II
 * ----------------------------
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * ------------------------------------------------------------------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntersectionOFTwoArraysii {

//    //[1]暴力法
//    static public int[] intersect(int[] nums1, int[] nums2) {
//        int length = nums1.length > nums2.length ? nums2.length : nums1.length;
//        int[] results = new int[length];
//        //双层循环，逐个遍历，遇到相同的终止内层遍历。
//        Set<Integer> existIndexSet = new HashSet<Integer>();
//        int count = 0;
//        for(int i = 0; i < nums1.length; i++){
//            for(int j =0; j<nums2.length; j++){
//                if(nums1[i] == nums2[j] && !existIndexSet.contains(j)){
//                    results[count++] =  nums1[i];
//                    existIndexSet.add(j);
//                    break;
//                }
//            }
//        }
//        return Arrays.copyOf(results, count);
//    }

//    //[2]暴力法：缩小遍历范围，使用最小数组，作为外层数组.
//    static public int[] intersect(int[] nums1, int[] nums2) {
//        int[] minNums;
//        int[] maxNums;
//        if(nums1.length > nums2.length){
//            minNums = nums2;
//            maxNums = nums1;
//        }else{
//            minNums = nums1;
//            maxNums = nums2;
//        }
//        int[] results = new int[minNums.length];
//        //双层循环，逐个遍历，遇到相同的终止内层遍历。
//        Set<Integer> existIndexSet = new HashSet<Integer>();
//        int count = 0;
//        for(int i = 0; i < minNums.length; i++){
//            for(int j =0; j<maxNums.length; j++){
//                if(minNums[i] == maxNums[j] && !existIndexSet.contains(j)){
//                    results[count++] = minNums[i];
//                    existIndexSet.add(j);
//                    break;
//                }
//            }
//        }
//        return Arrays.copyOf(results, count);
//    }


    //[3]升序数组，双指针不回溯遍历。
    static public int[] intersect(int[] nums1, int[] nums2) {
        int[] minNums;
        int[] maxNums;
        if (nums1.length > nums2.length) {
            minNums = nums2;
            maxNums = nums1;
        } else {
            minNums = nums1;
            maxNums = nums2;
        }
        int[] results = new int[minNums.length];
        Arrays.sort(minNums);
        Arrays.sort(maxNums);
        //双层循环，逐个遍历【由于是升序，可以不回溯，并且可以不适用Set过滤掉之前使用的数字】，遇到相同的终止内层遍历。
        int count = 0;
        int lastFindIndex = 0;
        for (int i = 0, j = 0; i < minNums.length; i++) {
            j =  lastFindIndex;
            for (; j < maxNums.length; j++) {
                if (minNums[i] == maxNums[j]) {
                    results[count++] = minNums[i];
                    j+=1;
                    lastFindIndex = j;//找到数值之后，后移一位.
                    break;
                }
                if(maxNums[j] > minNums[i]){//剪枝
                    break;
                }
            }
        }
        return Arrays.copyOf(results, count);
    }

    public static void main(String args[]) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2, 3};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
        int[] nums3 = {4,9,5,4};
        int[] nums4 = {9,4,9,8};
        System.out.println(Arrays.toString(intersect(nums3, nums4)));

    }


}

