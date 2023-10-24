package subject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 提示：
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class Subject56 {

    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (o1, o2) -> {

            if (o1[0] - o2[0] > 0) {
                return 1;
            } else if (o1[0] - o2[0] == 0) {
                return Integer.compare(o1[1] - o2[1], 0);
            } else {
                return -1;
            }
        });

        List<int[]> intervalList = new ArrayList<>();
        int[] interval = new int[2];


        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 0; i < n - 1; i++) {
            if (end < intervals[i + 1][0]) {
                // 间隔
                interval[0] = start;
                interval[1] = end;

                intervalList.add(interval);
                start = intervals[i + 1][0];
                end = intervals[i + 1][1];
                interval = new int[2];
            } else if (end < intervals[i + 1][1]) {
                // 交错
                end = intervals[i + 1][1];
            }
        }
        interval[0] = start;
        interval[1] = end;
        intervalList.add(interval);

        return intervalList.toArray(new int[intervalList.size()][2]);
    }

    public static void main(String[] args) {
//        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {2, 5},{8, 10}, {15, 18}};
        int[][] intervals = new int[][]{{1, 1}, {0, 1}};
//        int[][] intervals = new int[][]{{0, 2}, {1, 3}};
        int[][] result = merge(intervals);

        for (int[] ints : result) {
            System.out.print("[" + ints[0] + "," + ints[1] + "]");
        }
    }
}
