package com.tanyu.sort;

import java.util.Arrays;

/**
 * @author tanyu
 * @version 1.0
 * @description: TODO
 * @date 2021/1/5 3:09 下午
 */
public class MergeSort {

    public static void main(String[] args) {
        int []arr = {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }



    public static void sort(int[] nums) {
        int[] temp = new int[nums.length];
        sort(nums, 0, nums.length - 1, temp);
    }

    private static void sort(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(nums, left, mid, temp);
            sort(nums, mid + 1, right, temp);
            merge(nums, left, mid, right, temp);
        }
    }

    private static void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right) {
            if (nums[i] > nums[j]) {
                temp[t++] = nums[j++];
            }else {
                temp[t++] = nums[i++];
            }
        }

        while (i <= mid) {
            temp[t++] = nums[i++];
        }
        while (j <= mid) {
            temp[t++] = nums[j++];
        }
        t = 0;
        while (left <= right) {
           nums[left++] = temp[t++];
        }
    }
}
