package com.cci.trees.implemenation;

import java.util.ArrayList;
import java.util.Arrays;

public class MinHeap implements IHeap {

    private Integer[] heapdata = new Integer[100];
    int currentPos = 0;

    @Override
    public boolean insert(Integer value) {
        if (currentPos == 0) {
            heapdata[currentPos] = Integer.MIN_VALUE;
        }
        if (currentPos == heapdata.length) {

            return false;
        }
        currentPos++;

        heapdata[currentPos] = value;

        heapify(currentPos);

        return true;
    }


    public static void main(String[] args) {
        IHeap heap = new MinHeap();
        heap.insert(2);
        heap.insert(3);
        heap.insert(1);
        heap.insert(6);
        heap.insert(7);
        heap.insert(8);
        heap.insert(5);
        System.out.println(Arrays.deepToString(heap.getHeapdata()));

        System.out.println(heap.getMinNode());

        System.out.println(Arrays.deepToString(heap.getHeapdata()));

        heap.insert(1);

        System.out.println(Arrays.deepToString(heap.getHeapdata()));


    }


    @Override
    public void heapify(Integer index) {

        int parent = index / 2;
        while (index > 0 && heapdata[parent] > heapdata[index]) {
            swap(heapdata, parent, index);
            index = parent;
            parent = index / 2;

        }

    }

    @Override
    public void trickleDown(Integer index) {

        int currMin = index;

        int lIndex = index * 2;
        int rIndex = (index * 2) + 1;

        if (lIndex < heapdata.length && heapdata[lIndex] < heapdata[currMin]) {

            currMin = lIndex;
        }

        if (rIndex < heapdata.length && heapdata[rIndex] < heapdata[currMin]) {

            currMin = rIndex;
        }

        if (currMin != index) {
            swap(heapdata, currMin, index);

            trickleDown(currMin);

        }


    }

    @Override
    public Integer getMinNode() {

        Integer min = getHeapdata()[1];

        getHeapdata()[1] = getHeapdata()[currentPos];
        getHeapdata()[currentPos] = Integer.MAX_VALUE;
        currentPos--;

        trickleDown(1);


        return min;
    }

    @Override
    public Integer getMaxNode() {
        return null;
    }


    public void swap(Integer[] arr, int index1, int index2) {
        int tempInt = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tempInt;

    }


    public Integer[] getHeapdata() {
        return heapdata;
    }

    public void setHeapdata(Integer[] heapdata) {
        this.heapdata = heapdata;
    }

    public int getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(int currentPos) {
        this.currentPos = currentPos;
    }


}
