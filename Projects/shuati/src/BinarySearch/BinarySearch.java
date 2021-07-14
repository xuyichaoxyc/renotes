package BinarySearch;

/**
 * @author ：xuyichao
 * @description：Binary Search —— 二分搜索
 * 1. 循环退出条件，low <= high, 而不是 low < high
 * 2. mid 的取值，mid = low + (high - low) >> 1
 * 3. low 和 high 的更新。low = mid + 1, high = mid - 1
 * @date ：2021/7/6 14:33
 */
public class BinarySearch {
    /**
     * 二分查找/搜索
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchMatrix(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 二分搜索变种1：查找第一个和 target 相等的元素
     * 时间复杂度 O(logn)
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchFirstEqualElement(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) >> 1;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == 0 || (nums[mid - 1] != target)) {
                    // 找到第一个与 target 相等的元素
                    return mid;
                }

                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 二分搜索变种2：查找最后一个和 target 相等的元素
     * 时间复杂度 O(logn)
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchLastEqualElement(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) >> 1;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == nums.length - 1 || (nums[mid + 1] != target)) {
                    // 找到第一个与 target 相等的元素
                    return mid;
                }

                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分搜索变种3：查找第一个大于等于 target 的元素
     * 时间复杂度 O(logn)
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchFirstGreaterElement(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) >> 1;
            if (nums[mid] >= target) {
                if (mid == 0 || (nums[mid - 1] < target)) {
                    return mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分搜索变种4：查找最后一个小于等于 target 的元素
     * 时间复杂度 O(logn)
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchLastLessElement(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) >> 1;
            if (nums[mid] <= target) {
                if (mid == nums.length - 1 || (nums[mid + 1] > target)) {
                    return mid;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
