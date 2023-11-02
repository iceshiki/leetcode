package subject;

/**
 * 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * 示例 1:
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * <p>
 * 示例2:
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 105
 * -104<= nums[i] <= 104
 *
 * @author ice_shiki
 * @createDate 2022/11/17 11:20
 */
public class Subject215 {

    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeap(nums, i, heapSize);
        }


        for (int i = 0; i < k-1; i++) {
            swap(nums, heapSize - 1, 0);
            heapSize--;
            maxHeap(nums, 0, heapSize);
        }
        return nums[0];
    }


    public void maxHeap(int[] nums, int i, int heapSize) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int largest = i;

        if (l < heapSize && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < heapSize && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(nums, i, largest);
            maxHeap(nums, largest, heapSize);
        }

    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Subject215 subject215 = new Subject215();
        System.out.println(subject215.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 3));
        System.out.println(subject215.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 3));
    }
}
