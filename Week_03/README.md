# 学习笔记

## 03本周作业提交记录：
#### 实战题目：
* [爬楼梯](_01_0070_ClimbingStairs.java)（阿里巴巴、腾讯、字节跳动在半年内面试常考）：使用非递归方式（缓存上次结果）解决该题。
* [括号生成](_02_0022_GenerateParentheses.java) (字节跳动在半年内面试中考过)：使用递归+剪枝方法解决该题。
* [翻转二叉树](_03_0226_InvertBinaryTree.java) (谷歌、字节跳动、Facebook 在半年内面试中考过)：使用递归+剪枝方法解决该题（核心思想左右交互）。
* [二叉树的最小深度](_06_0111_MinimumDepthOfBinaryTree.java) (Facebook、字节跳动、谷歌在半年内面试中考过)：使用递归方法解决该题（和最大深度有些区别，同时题干要求必须遍历到叶子结点，如果根节点有一个子树为null则还要继续遍历另一棵非空子树）。
* [二叉树的序列化与反序列化](_07_0297_SerializeAndDeserializeBinaryTree.java) (Facebook、亚马逊在半年内面试常考)：使用“层序遍历：空结点也入队列”的方式解决该问题（该题难度等级为困难，同时在处理该题时，发现似乎是官方验证机制的一个问题，详细如下）。
```java []
//测试用例的测试机制似乎有bug，例如：
Codec test= new Codec();
System.out.println(test.serialize_error(test.deserialize("[1,2,3,null,null,4,5]")));
//本地运行时，错误输出：[1,2,3,null,null,4,5,null,null,null,null]
//但，此时若将serialize_error()修改为serialize()作为答案（其中serialize_error()函数见上述代码），提交，也会通过测试用例。
```
#### 本周作业【中等】：
* [二叉树的最近公共祖先](_08_0236_LowestCommonAncestorOfABinaryTree.java)（Facebook 在半年内面试常考）：使用递归解决该题（核心思想弄清出现的三种情况，进行层层分析递归出口和下层处理逻辑）。
* [从前序与中序遍历序列构造二叉树](_09_0105_ConstructBinaryTreeFromPreorderAndInorderTraversal.java)（字节跳动、亚马逊、微软在半年内面试中考过）：使用分治思想解决该问题，同时使用中序遍历的特性判断左右子树.


## 本周总结：
本周参与了**第03周课程**和[**每日一题刷题**](one-question-per-day_03week)活动，继续强化“自顶向下编程”的方法论，强化使用递归模板，运用到编程中，编程思想和解决问题的能力有了改善。

本周重点学习了各种树的递归、分治、回溯等相关知识，尤其是对于递归和分治相关知识，有了更清晰认识，回溯思想还有待强化训练。

最后打上还有待加强的秘籍：**谭超老师讲授的五毒神掌**：
1. 敢于记忆，敢于死记硬背
2. 马上，不看写出来。同时 多种解法比较，体会，优化 （Feedback & Summary）
3. 24小时重复写出来
4. 一周后重复写出来
5. 反复回顾练习学习笔记