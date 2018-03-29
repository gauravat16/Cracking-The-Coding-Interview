package com.cci.trees.implemenation;

public interface IHeap {

    boolean insert(Integer value);

    void heapify(Integer node);

    void trickleDown(Integer node);

    Integer getMinNode();

    Integer getMaxNode();

    void swap(Integer[] arr, int index1, int index2);

    Integer[] getHeapdata();

    void setHeapdata(Integer[] heapdata);

    int getCurrentPos();


}
