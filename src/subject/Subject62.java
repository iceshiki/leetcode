package subject;

import java.util.Arrays;
import java.util.Stack;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * <p>
 * 示例 1：
 * 输入：m = 3, n = 7
 * 输出：28
 * <p>
 * 示例 2：
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * <p>
 * 示例 3：
 * 输入：m = 7, n = 3
 * 输出：28
 * <p>
 * 示例 4：
 * 输入：m = 3, n = 3
 * 输出：6
 * <p>
 * 提示：
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 109
 *
 * @level meidum
 */
public class Subject62 {

    /* 递归算法超时
        public int uniquePaths(int m, int n) {
            pathNum = 0;
            this.m = m;
            this.n = n;
            if (m == 1 || n == 1) {
                return 1;
            }
            divide(1, 0, true);
            divide(0, 1, false);
            return pathNum;
        }

        public void divide(int stepDown, int stepRight, boolean isDown) {
            if (stepDown + 1 == m && stepRight + 1 == n) {
                pathNum++;
                return;
            }
            if (stepDown + 1 < m) {
                divide(stepDown + 1, stepRight, true);
            }
            if (stepRight + 1 < n) {
                divide(stepDown, stepRight + 1, false);
            }
        }*/

    /**
     * 动态规划
     *
     * @param m 长
     * @param n 宽
     * @return 路径数量
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Subject62 subject62 = new Subject62();
        // 0
        System.out.println(subject62.uniquePaths(1, 1));
        // 28
        System.out.println(subject62.uniquePaths(3, 7));
        // 3
        System.out.println(subject62.uniquePaths(3, 2));
        // 1
        System.out.println(subject62.uniquePaths(3, 1));
        // 1
        System.out.println(subject62.uniquePaths(1, 3));
    }
}
