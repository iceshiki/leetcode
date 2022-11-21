package subject;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * <p>
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组[4,-1,2,1] 的和最大，为6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 * @author: ice_shiki
 * @createDate: 2022/11/21
 */
public class Subject53 {
    /**
     * 分治算法
     * num[i]代表i为止最大子串的最大值
     * Math.max(0, nums[i - 1])代表前一位如果是正数则累加可加大最大值的数值，否则就是加0，即本身
     *
     * @param nums 数组
     * @return 最大子串的最大值
     */
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + Math.max(0, nums[i - 1]);
            max = Math.max(max, nums[i]);
        }
        /*
        思想二，前一个累加和小于0直接置0，即前面所有累加结果不参与计算
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < 0) {
                nums[i - 1] = 0;
            }
            nums[i] = nums[i] + nums[i - 1];
            max = Math.max(max, nums[i]);
        }
         */
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}
