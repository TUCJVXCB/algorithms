package com.tanyu;

/**
 * @author tanyu
 * @version 1.0
 * @description: 基于heap的优先队列
 * @date 2020/12/21 10:12 下午
 */
public class MaxPQ<T extends Comparable<T>> {

    private T[] pq;

    private Integer N = 0;

    public MaxPQ(int length) {
        pq = (T[]) new Comparable[length + 1];
    }

    public void insert(T t) {
        pq[++N] = t;
        swim(N);
    }

    public T delMax() {
        T result = pq[1];
        exchange(1, N--);
        pq[N+1] = null;
        sink(1);
        return result;
    }



    /***
     * @description: 从下往上浮
     * @author tanyu
     * @date: 2020/12/21 10:21 下午
     */
    public void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exchange(k/2, k);
            k /= 2;
        }
    }

    /***
     * @description:  从上往下沉
     * @author tanyu
     * @date: 2020/12/21 10:25 下午
     */
    public void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(j, j+1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exchange(k, j);
            k = j;
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private void exchange(int i, int j) {
        T flag = pq[i];
        pq[i] = pq[j];
        pq[j] = flag;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    public static void main(String[] args) {
        MaxPQ<Integer> pq = new MaxPQ<>(10);
        pq.insert(5);
        pq.insert(8);
        pq.insert(7);
        pq.insert(1);
        pq.insert(10);
    }
}
