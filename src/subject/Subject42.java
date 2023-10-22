package subject;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 *
 * @link <a href="https://leetcode.cn/problems/trapping-rain-water/description/">...</a>
 */
public class Subject42 {
    /**
     * 这个算法超时了
     *
     * @param height
     * @return
     */
    public static int trap1(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int sum = 0;
        int top = 0;
        for (int i : height) {
            top = Math.max(top, i);
        }

        int f = 1;
        while (f <= top) {
            int l = 0;
            int r = l + 1;
            int w = 0;
            while (r < height.length) {
                if (height[l] < f) {
                    l++;
                    r = l + 1;
                    continue;
                }
                if (height[r] >= f) {
                    l = r;
                    r = l + 1;
                    sum += w;
                    w = 0;
                    continue;
                }
                w++;
                r++;
            }
            f++;
        }
        return sum;
    }


    /**
     * 动态规划
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int sum = 0;
        int[] lMax = new int[height.length];
        int[] rMax = new int[height.length];

        lMax[0] = height[0];
        for (int i = 1; i < height.length; ++i) {            lMax[i] = Math.max(lMax[i - 1], height[i]);
        }

        rMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i+1], height[i]);
        }


        for (int i = 0; i < height.length; i++) {
            sum += Math.min(lMax[i], rMax[i]) - height[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        int[] height = {2,0,2};
        System.out.println(trap(height));

    }
}
