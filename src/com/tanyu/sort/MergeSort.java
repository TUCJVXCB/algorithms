package com.tanyu.sort;

import java.util.Arrays;

/**
 * @author tanyu
 * @version 1.0
 * @description: 归并排序
 * @date 2021/1/5 3:09 下午
 */
public class MergeSort {

    public static void main(String[] args) {
        int []arr = {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        int[] temp = new int[arr.length];
        sort(arr, 0, temp.length - 1, temp);
    }

    private static void sort(int[] arr, int low, int high, int[] temp) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(arr, low, mid, temp);
            sort(arr, mid + 1, high, temp);
            merge(arr, low, mid, high, temp);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high, int[] temp) {
        int i = low;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = arr[i++];
        }

        while (j <= high) {
            temp[t++] = arr[j++];
        }
        t = 0;
        while (low <= high) {
            arr[low++] = temp[t++];
        }
    }
}
