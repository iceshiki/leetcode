package subject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * <p>
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 */
public class Subject78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subSetList = new ArrayList<>();
        List<List<Integer>> newList = new ArrayList<>();

        for (int num : nums) {
            List<Integer> newIntegers;

            if (!subSetList.isEmpty()) {
                for (List<Integer> integers : subSetList) {
                    newIntegers = new ArrayList<>(integers);
                    newIntegers.add(num);
                    newList.add(newIntegers);
                }
                subSetList.addAll(newList);
                newList.clear();
            }

            newIntegers = new ArrayList<>();
            newIntegers.add(num);
            subSetList.add(newIntegers);
        }
        subSetList.add(new ArrayList<>());
        return subSetList;
    }

    public static void main(String[] args) {
        Subject78 subject78 = new Subject78();
        List<List<Integer>> subsets = subject78.subsets(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(subsets.toArray()));
    }
}
