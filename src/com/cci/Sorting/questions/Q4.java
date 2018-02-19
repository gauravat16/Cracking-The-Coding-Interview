package com.cci.Sorting.questions;

import java.util.ArrayList;
import java.util.List;

public class Q4 {


    public static boolean search(Listy listy, Integer searchVal) {
        Integer index = 1;
        while (listy.getVal(index) != -1 && listy.getVal(index) < searchVal) {
            index *= 2;
        }

        return binarySearch(listy, searchVal, 0, index);

    }

    private static boolean binarySearch(Listy listy, Integer searchVal, Integer start, Integer end) {

        int middle = (start + end) / 2;

        if (listy.getVal(middle) == -1) {
            return false;
        }

        if (listy.getVal(middle) == searchVal) {
            return true;
        }

        if (listy.getVal(middle) < searchVal) {
            return binarySearch(listy, searchVal, middle + 1, end);
        } else {
            return binarySearch(listy, searchVal, start, middle);
        }
    }


    public static void main(String[] args) {
        Listy listy = new Listy();

        listy.addElem(1);
        listy.addElem(2);
        listy.addElem(3);
        listy.addElem(4);
        listy.addElem(5);
        listy.addElem(6);
        listy.addElem(7);
        listy.addElem(8);

        System.out.println(search(listy, 11));


    }


}


class Listy {

    List<Integer> integerList;

    public Listy() {
        integerList = new ArrayList<>();
    }

    public void addElem(Integer intVal) {
        integerList.add(intVal);
    }

    public int getVal(Integer index) {
        int retval = -1;

        try {
            retval = integerList.get(index);
        } catch (Exception e) {

        }
        return retval;
    }
}
