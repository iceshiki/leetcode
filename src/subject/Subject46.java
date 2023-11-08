package subject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 * 提示：
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 *
 * @level medium
 */
public class Subject46 {
    public List<List<Integer>> permute(int[] nums) {
        int[] takeMark = new int[nums.length];
        Arrays.fill(takeMark, -1);
        List<List<Integer>> result = new ArrayList<>(nums.length);
        premute(nums, takeMark, 0, result);
        return result;
    }

    private void premute(int[] nums, int[] takeMark, int depth, List<List<Integer>> result) {
        if (depth == nums.length) {
            int[] resultArr = new int[nums.length];

            for (int i = 0; i < takeMark.length; i++) {
                resultArr[i] = nums[takeMark[i]];
            }
            List<Integer> ts = new ArrayList<>();
            for (int i : resultArr) {
                ts.add(i);
            }
            result.add(ts);
            return;
        }
        for (int i = 0; i < takeMark.length; i++) {
            if (takeMark[i] == -1) {
                takeMark[i] = depth;
                premute(nums, takeMark, ++depth, result);
                --depth;
                takeMark[i] = -1;
            }
        }


    }

    private void sout(List<List<Integer>> permute) {
        for (List<Integer> integers : permute) {
            System.out.println(Arrays.toString(integers.toArray()));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Subject46 subject46 = new Subject46();
        subject46.sout(subject46.permute(new int[]{1, 2, 3}));
        subject46.sout(subject46.permute(new int[]{0, 1}));
        subject46.sout(subject46.permute(new int[]{0}));
    }
}
