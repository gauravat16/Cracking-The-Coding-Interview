package com.cci.Sorting.questions;

import java.util.ArrayList;
import java.util.List;

public class Q5 {

    static boolean search(List<String> strings, String toFind) {
        return search(strings, toFind, 0, strings.size() - 1);
    }

    static boolean search(List<String> strings, String toFind, int start, int end) {

        if (start > end) {
            return false;
        }

        int middle = (start + end) / 2;
        int left = middle - 1;
        int right = middle + 1;

        if (strings.get(middle).isEmpty()) {

            while (left >= start && right <= end) {

                if (!strings.get(left).isEmpty()) {
                    middle = left;
                    break;

                }

                if (!strings.get(right).isEmpty()) {
                    middle = right;
                    break;

                }

                left--;
                right++;
            }

        }

        if (strings.get(middle).equals(toFind)) {
            return true;
        }

        if (strings.get(middle).compareTo(toFind) > 0) {
            return search(strings, toFind, start, middle - 1);
        } else {
            return search(strings, toFind, middle + 1, end);

        }
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("at");
        strings.add("");
        strings.add("");
        strings.add("");
        strings.add("ball");
        strings.add("");
        strings.add("");
        strings.add("car");
        strings.add("");
        strings.add("");
        strings.add("dad");
        strings.add("");
        strings.add("");

        System.out.println(search(strings, "at"));
    }
}
