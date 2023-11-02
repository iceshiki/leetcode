package subject;

import java.util.*;

/**
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * <p>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例 1：
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：[["Q"]]
 * <p>
 * <p>
 * 提示：
 * 1 <= n <= 9
 */
public class Subject51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> boradResultList = new ArrayList<>();

        Set<Integer> cloneSet = new HashSet<>();
        Set<Integer> rightDiagonals = new HashSet<>();
        Set<Integer> leftDiagonals = new HashSet<>();
        char[][] chess = new char[n][n];
        for (char[] chessLine : chess) {
            Arrays.fill(chessLine, '.');
        }
        setUp(n, 0, chess, cloneSet, rightDiagonals, leftDiagonals, boradResultList);


        return boradResultList;

    }

    private void setUp(int n, int k, char[][] chess, Set<Integer> cloneSet, Set<Integer> rightDiagonals, Set<Integer> leftDiagonals, List<List<String>> boradResultList) {
        for (int i = 0; i < n; i++) {
            if (cloneSet.contains(i) || rightDiagonals.contains(k + i) || leftDiagonals.contains(k - i)) {

            } else {
                chess[k][i] = 'Q';
                cloneSet.add(i);
                rightDiagonals.add(k + i);
                leftDiagonals.add(k - i);
                if (k == n - 1) {

                    List<String> result = new ArrayList<>();
                    for (char[] chars : chess) {
//                        System.out.println(Arrays.toString(chars));
                        result.add(new String(chars));
                    }
//                    System.out.println("-----------------------------");
                    boradResultList.add(result);

                } else {
                    setUp(n, k + 1, chess, cloneSet, rightDiagonals, leftDiagonals, boradResultList);
                }
                cloneSet.remove(i);
                rightDiagonals.remove(k + i);
                leftDiagonals.remove(k - i);
                chess[k][i] = '.';
            }
        }
    }

    public static void main(String[] args) {
        Subject51 subject51 = new Subject51();

        List<List<String>> boradResultList = subject51.solveNQueens(4);
        for (List<String> strings : boradResultList) {
            System.out.println(Arrays.toString(strings.toArray()));
        }
    }
}
