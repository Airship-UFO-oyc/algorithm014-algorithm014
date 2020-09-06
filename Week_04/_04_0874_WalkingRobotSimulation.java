package homework._04week;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 874. 模拟行走机器人
 * ----------------------------
 * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物。
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。
 * ---------------------------
 * 示例 1：
 * 输入: commands = [4,-1,3], obstacles = []
 * 输出: 25
 * 解释: 机器人将会到达 (3, 4)
 * ------
 * 示例 2：
 * 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出: 65
 * 解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
 * ------------------------------
 * 提示：
 * 0 <= commands.length <= 10000
 * 0 <= obstacles.length <= 10000
 * -30000 <= obstacle[i][0] <= 30000
 * -30000 <= obstacle[i][1] <= 30000
 * 答案保证小于 2 ^ 31
 * ------------------------------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/walking-robot-simulation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ------------------------------------------------------------------------------------------
 */
public class _04_0874_WalkingRobotSimulation {


    //[1]贪心
    public int robotSim(int[] commands, int[][] obstacles) {
        //x,y表示当前所在坐标；maxDistance表示最大距离；direction表示当前方向，
        int x = 0, y = 0, maxDistance = 0, direction = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//向北[向上],向东(向右),向南(向下),向西(向左)
        Set<String> obstacleSet = new HashSet<>();
        //将坐标按照，加入集合.
        for (int i = 0; i < obstacles.length; i++) obstacleSet.add(obstacles[i][0] + "_" + obstacles[i][1]);
        for (int i = 0; i < commands.length; i++) {
            if (-1 == commands[i]) direction = (direction + 1) % 4;//右转90度：相对原始位置，顺时针转动1次
            else if (-2 == commands[i]) direction = (direction + 3) % 4;//左转90度：相对原始位置，顺时针转动3次
            else {//在当前方向上面，移动指定步数.
                for (int j = 0; j < commands[i]; j++) {
                    int nextX = x + directions[direction][0];
                    int nextY = y + directions[direction][1];
                    if (obstacleSet.contains(nextX + "_" + nextY)) break;//遇到障碍，则停留在此处，并接受在此方向的本轮移动。
                    x = nextX;
                    y = nextY;
                    maxDistance = Math.max(maxDistance, x * x + y * y);
                }
            }
        }
        return maxDistance;
    }


    public static void main(String args[]) {
        int[] commands1 = {4, -1, 3};
        int[][] obstacles1 = {};
        int[] commands2 = {4, -1, 4, -2, 4};
        int[][] obstacles2 = {{2, 4}};
        System.out.println(new _04_0874_WalkingRobotSimulation().robotSim(commands1, obstacles1));
        System.out.println(new _04_0874_WalkingRobotSimulation().robotSim(commands2, obstacles2));
    }

}

