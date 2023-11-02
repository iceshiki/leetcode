package subject;

import java.util.*;

public class Subject52 {
    private int count = 0;
    public int solveNQueens(int n) {

        Set<Integer> cloneSet = new HashSet<>();
        Set<Integer> rightDiagonals = new HashSet<>();
        Set<Integer> leftDiagonals = new HashSet<>();
        char[][] chess = new char[n][n];
        for (char[] chessLine : chess) {
            Arrays.fill(chessLine, '.');
        }
        setUp(n, 0, chess, cloneSet, rightDiagonals, leftDiagonals);

        int result = count;
        count = 0;
        return result;

    }

    private void setUp(int n, int k, char[][] chess, Set<Integer> cloneSet, Set<Integer> rightDiagonals, Set<Integer> leftDiagonals) {
        for (int i = 0; i < n; i++) {
            if (!cloneSet.contains(i) && !rightDiagonals.contains(k + i) && !leftDiagonals.contains(k - i)) {
                chess[k][i] = 'Q';
                cloneSet.add(i);
                rightDiagonals.add(k + i);
                leftDiagonals.add(k - i);
                if (k == n - 1) {
                    count++;
                } else {
                    setUp(n, k + 1, chess, cloneSet, rightDiagonals, leftDiagonals);
                }
                cloneSet.remove(i);
                rightDiagonals.remove(k + i);
                leftDiagonals.remove(k - i);
                chess[k][i] = '.';
            }
        }
    }

    public static void main(String[] args) {
        Subject52 subject52 = new Subject52();
        System.out.println(subject52.solveNQueens(1));;
        System.out.println(subject52.solveNQueens(4));;
    }
}
