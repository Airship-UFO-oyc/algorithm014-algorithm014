package _2020._09._04;

/**
 * 200. 岛屿数量
 * ----------------------------
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * -------------------
 * 示例 1:
 * 输入:
 * [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出: 1
 * -----------------
 * 示例 2:
 * 输入:
 * [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 * -----------------------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ------------------------------------------------------------------------------------------
 */
public class _01_0200_NumberOfIslands {


    // 方向数组，记录4个偏移量【很强的想法】
    private static final int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    int rows = 0;
    int cols = 0;
    // 标记数组，标记格子是否被访问过
    private boolean[][] marked;

    //[1]深度优先遍历DFS：DFS的次数，即为岛屿的数量.
    public int numIslands(char[][] grid) {
        if (null == grid || grid.length == 0) return 0;
        int count = 0;
        rows = grid.length;
        cols = grid[0].length;
        marked = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!marked[i][j] && grid[i][j] == '1') {
                    count++;
                    df(i, j, grid);
                }
            }
        }
        return count;
    }

    private void df(int i, int j, char[][] grid) {
        marked[i][j] = true;
        // 得到 4 个方向的坐标
        for (int k = 0; k < 4; k++) {
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            // 如果不越界、没有被访问过、并且还要是陆地
            if (isInArea(newX, newY) && grid[newX][newY] == '1' && !marked[newX][newY]) {
                df(newX, newY, grid);
            }
        }
    }

    // 封装成 inArea 方法语义更清晰
    private boolean isInArea(int x, int y) {
        // 等于号不要忘了
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }


    public static void main(String args[]) {
//        System.out.println(new _01_0200_NumberOfIslands().numIslands());
    }

}

