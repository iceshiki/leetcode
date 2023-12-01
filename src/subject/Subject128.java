package subject;

import java.util.HashSet;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * <p>
 * 提示：
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 *
 * @level medium
 */
public class Subject128 {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength = 0;
        for (Integer integer : numSet) {
            if (!numSet.contains(integer-1)){
                integer++;
                int tempLength = 1;
                while (numSet.contains(integer)){
                    tempLength++;
                    integer++;
                }
                maxLength = Math.max(tempLength, maxLength);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Subject128 subject128 = new Subject128();
        System.out.println(subject128.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(subject128.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(subject128.longestConsecutive(new int[]{}));
        System.out.println(subject128.longestConsecutive(new int[]{2}));
    }
}
