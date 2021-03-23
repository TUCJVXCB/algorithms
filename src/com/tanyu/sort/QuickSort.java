package com.tanyu.sort;

import java.util.Arrays;

/**
 * @author tanyu
 * @version 1.0
 * @description: 快速排序
 * @date 2021/1/8 10:26 上午
 */
public class QuickSort {
    public static void main(String[] args) {
        int []arr = {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int[] nums) {
        _sort(nums, 0, nums.length - 1);
    }

    private static void _sort(int[] nums, int i, int j) {
        if (i > j) {
            return;
        }
        int low = i;
        int high = j;
        int p = nums[low];

        while (low < high) {
            while (low < high && p <= nums[high]) {
                high--;
            }
            if (low < high) {
                nums[low++] = nums[high];
            }
            while (low < high && p >= nums[low]) {
                low++;
            }
            if (low < high) {
                nums[high--] = nums[low];
            }
            nums[low] = p;
            _sort(nums, i, low - 1);
            _sort(nums, low + 1, j);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        return _findKthLargest(nums, 0, nums.length -  1, nums.length - k);
    }

    private int _findKthLargest(int[] nums, int low, int high, int index) {
        int p = position(nums, low, high);
        if (p == index) {
            return nums[p];
        }
        return p < index ? _findKthLargest(nums, p + 1, high, index) : _findKthLargest(nums, low, p - 1, index);
    }

    private int position(int[] nums, int i, int j) {
        if (i > j) {
            return i;
        }
        int low = i;
        int high = j;
        int p = nums[low];

        while (low < high) {
            while (low < high && p <= nums[high]) {
                high--;
            }
            if (low < high) {
                nums[low++] = nums[high];
            }
            while (low < high && p >= nums[low]) {
                low++;
            }
            if (low < high) {
                nums[high--] = nums[low];
            }
        }
        nums[low] = p;
        return low;
    }
}
