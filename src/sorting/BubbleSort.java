package sorting;

import leetcode.may_april_june_challenge.Helper;

public class BubbleSort {

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j - 1] > arr[j])
                    swap(arr, j - 1, j);
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        int[] test = Helper.parseIntegerArray("[1001,0,1,5,99,0,1,293588]");
        bs.sort(test);
        for (int i : test) {
            System.out.print(i + " ");
        }
    }
}
