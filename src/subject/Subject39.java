package subject;

import java.util.*;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * <p>
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * <p>
 * 示例 2：
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * <p>
 * 示例 3：
 * 输入: candidates = [2], target = 1
 * 输出: []
 * <p>
 * 提示：
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * candidates 的所有元素 互不相同
 * 1 <= target <= 40
 *
 * @level medium
 */
public class Subject39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayDeque<>(), result);
        return result;
    }

    /**
     * 深度优先，回溯，剪枝
     * @param candidates
     * @param target
     * @param begin
     * @param path
     * @param result
     */
    private void dfs(int[] candidates, int target, int begin, Deque<Integer> path, List<List<Integer>> result) {
        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] > 0) {
                path.add(candidates[i]);
                dfs(candidates, target - candidates[i], i, path, result);
                path.removeLast();
            } else if (target == candidates[i]) {
                path.add(candidates[i]);
//                System.out.println(Arrays.toString(path.toArray()) + "match");
                List<Integer> integers = new ArrayList<>(path);
                result.add(integers);
                path.removeLast();
            } /*else {
                path.add(candidates[i]);
                System.out.println(Arrays.toString(path.toArray())+ "over fit");
                path.removeLast();
            }*/
        }
    }

    private int sumPath(Deque<Integer> path) {
        int sum = 0;
        for (Integer integer : path) {
            sum += integer;
        }

        return sum;
    }

    public static void main(String[] args) {
        Subject39 subject39 = new Subject39();
        List<List<Integer>> lists = subject39.combinationSum(new int[]{8, 7, 4, 3}, 11);
//        List<List<Integer>> lists = subject39.combinationSum(new int[]{2, 3, 6,7}, 7);
//        List<List<Integer>> lists = subject39.combinationSum(new int[]{2, 3, 7}, 8);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
