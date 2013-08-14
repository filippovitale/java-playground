package it.filippovitale.playground;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseArrayList {

    // Q: How to reverse elements in ArrayList?
    public static void reverseArrays(List<?> forwardArray) {
        Collections.reverse(forwardArray);
    }

    public static void reverse(int[] a) {
        int i = 0;
        int j = a.length - 1;

        while (i < j) {
            int t = a[j];
            a[j] = a[i];
            a[i] = t;

            i++;
            j--;
        }
    }

    public static int[] reverseArray(int[] forwardArray) {
        int[] reverseArray = null;
        return reverseArray;
    }
}
