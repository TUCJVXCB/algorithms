package com.tanyu;

/**
 * @author tanyu
 * @version 1.0
 * @description: max heap, the index of array, start from 1
 * @date 2021/1/4 8:05 下午
 */
public class Heap {
    // the size of this heap
    private final int size;

    // array to store num
    private final int[] nums;

    // array's pointer, represent how much heap is used
    private int pointer = 1;

    public Heap(int size) {
        this.size = size;
        this.nums = new int[size];
    }

    public Heap(int[] nums) {
        size = nums.length;
        this.nums = nums;
    }

    int add(int i) {
        if (pointer > size - 1) {
            throw new RuntimeException("the space of heap is exhausted");
        }

        nums[pointer] = i;
        heapifyFromBottomToTop(nums, pointer);
        pointer++;
        return i;
    }

    int removeMax() {
        int indexOfLast = pointer - 1;
        int max = nums[1];
        // move the last element to top
        nums[1] = nums[indexOfLast];
        heapifyFromTopToDown(nums, 1);
        pointer--;
        return max;
    }

    /***
     * @description: adjust array to heap, top down
     * @param:  * @param nums
     * @return: void
     * @author tanyu
     * @date: 2021/1/5 11:12 上午
     */
    private void heapifyFromTopToDown(int[] nums, int currentIndex) {
        if (currentIndex > size - 1 || 2 * currentIndex > pointer - 1) {
            return;
        }
        int indexOfChild = findMaxChild(currentIndex);
        if (nums[currentIndex] >= nums[indexOfChild]) {
            return;
        }
        exchange(nums, currentIndex, indexOfChild);
        heapifyFromTopToDown(nums, indexOfChild);
    }

    private int findMaxChild(int currentIndex) {
        int indexOfLeftNode = 2 * currentIndex;
        int indexOfRightNode = 2 * currentIndex + 1;

        if (indexOfRightNode > pointer - 1) {
            return indexOfLeftNode;
        }
        return nums[indexOfLeftNode] > nums[indexOfRightNode] ? indexOfLeftNode : indexOfRightNode;
    }

    /***
     * @description: adjust array to heap, from bottom to top
     * @return: void
     * @author tanyu
     * @date: 2021/1/4 8:23 下午
     */
    private void heapifyFromBottomToTop(int[] nums, int currentIndex) {
        // root already
        if (currentIndex == 1) {
            return;
        }
        int indexOfLastElementParent = currentIndex / 2;
        // if new element less than his parent, not need adjust
        if (nums[currentIndex] <= nums[indexOfLastElementParent]) {
            return;
        }

        // if new element more than his parent, exchange the position of each other
        exchange(nums, currentIndex, indexOfLastElementParent);
        heapifyFromBottomToTop(nums, indexOfLastElementParent);
    }

    private void exchange(int[] nums, int currentIndex, int indexOfLastElementParent) {
        int flag = nums[currentIndex];
        nums[currentIndex] = nums[indexOfLastElementParent];
        nums[indexOfLastElementParent] = flag;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Heap");

        for (int i = 0;i < pointer; i++) {
            str.append("," + nums[i]);
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.add(9);
        heap.add(10);
        heap.add(8);
        heap.add(6);
        heap.add(5);

        System.out.println(heap);

        int i = heap.removeMax();
        System.out.println(i);
        System.out.println(heap);

        heap.removeMax();
        System.out.println(heap);

        heap.removeMax();
        System.out.println(heap);

        heap.removeMax();
        System.out.println(heap);

        heap.removeMax();
        System.out.println(heap);

        heap.removeMax();
        System.out.println(heap);
    }
}
