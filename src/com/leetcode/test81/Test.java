package com.leetcode.test81;

/**
 * @author chris
 * @version V1.0
 * @package com.力扣.test81
 * @date 2022/3/19 15:30
 */

public class Test {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 4, 4, 5, 6, 6, 7};
        int target = 5;
    }
}

class Solution {
    /**
     * 暴力法:一次能过,但是题目考察我们的不是这个
     *
     * @param nums   int[]
     * @param target int 目标
     * @return boolean
     */
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}

/**
 * 由题目可知这个数组是原本是一个非降序排列的整数数组.
 * 那我们用一个k把它旋转的话,那么就分成了两个不降序数组
 * 用二分查找法来查找 时间复杂度 O(log n)
 */
class Solution02 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        // 特殊情况判断
        if (n == 0) {
            return false;
        }
        // 特殊情况判断
        if (n == 1) {
            return nums[0] == target;
        }
        // 定义左右指针
        int l = 0, r = n - 1;
        // 这个旋转把两边分成了两个非降序数组.
        // 左边的比右边最大的大.
        while (l <= r) {
            // 获取中间值
            int mid = (l + r) / 2;
            // 找到目标值,直接返回true
            if (nums[mid] == target) {
                return true;
            }
            // 如果两个指针指向的元素都等于 nums[mid]
            // 那么说明原来的k是在原来的mid上
            // 这里的if指的是 nums[l] != target && nums[r] != target
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                // 说明这 l 和 r 这个位置都不是target所在的位置
                // 所以把这两个位置去除, l++ , r--;
                l++;
                r--;
                // else if 语句等于 nums[l] != nums[mid] && nums[r] != nums[mid] && nums[l] <= nums[mid]
                //  l ~ mid 是非递减数组
            } else if (nums[l] <= nums[mid]) {
                // 这个if语句指的是
                // nums[l] != nums[mid] && nums[r] != nums[mid] && nums[l] <= nums[mid] && nums[l] <= target  && target < nums[mid]
                // 说明 target 在 (nums[l] ~ nums[mid - 1] 上面已经证明了 l ~ mid 是非递减数组
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                    // 这里的else 指的是 nums[l] > target && target >= nums[mid]
                    // 说明target 在mid的后面
                    // target 在 (nums[mid] ~ nums[r])之间
                } else {
                    l = mid + 1;
                }
                // 这里的else指的是 nums[l] != nums[mid] && nums[r] != nums[mid] && nums[l] > nums[mid]
                // l ~ mid 之间有一段是第一个非递减数组,有一段是第二个非递增数组
                // mid ~ r 之间都是非递增数组
            } else {
                // 说明target在 (nums[mid - 1] ~ nums[r] 之间)
                // 所以 l = mid - 1
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                    // 这里的else指的是 nums[mid] >= target && target > nums[n-1]
                    // 说明 target在(nums[l] ~ nums[mid -1]之间] 而 target > nums[n-1]
                    // 所以 r = mid - 1
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}