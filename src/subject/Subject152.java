package subject;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 测试用例的答案是一个 32-位 整数。
 * 子数组 是数组的连续子序列。
 * <p>
 * 示例 1:
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * <p>
 * 示例 2:
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * <p>
 * <p>
 * 提示:
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数
 *
 * @level medium
 */
public class Subject152 {
    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int maxPositive = nums[0];
        int minNegative = nums[0];
        int max = nums[0];
        int tmpMax;
        int tmpMin;
        for (int i = 1; i < nums.length; i++) {
            tmpMax = maxPositive;
            tmpMin = minNegative;
            // 保存当前可能得最大正数,max(当前*前一个最大正数， max(前一个最小负数*当前))，内层max可能是负负得正
            maxPositive = Math.max(nums[i] * tmpMax, Math.max(tmpMin * nums[i], nums[i]));
            // 保存当前可能得最小数，为了负数准备的
            minNegative = Math.min(nums[i] * tmpMin, Math.min(tmpMax * nums[i], nums[i]));
            max = Math.max(maxPositive, max);
        }
        return max;
    }

    public static void main(String[] args) {
        Subject152 subject152 = new Subject152();
//        System.out.println(subject152.maxProduct(new int[]{2, 3, -2, 4}));
//        System.out.println(subject152.maxProduct(new int[]{-2, 0, -1}));
//        System.out.println(subject152.maxProduct(new int[]{-2, 3, -4}));
        System.out.println(subject152.maxProduct(new int[]{-1, -2, -9, -6}));
    }
}
