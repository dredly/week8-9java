
import java.util.Arrays;

public class QuickSort {

    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            sort(arr, left, pivotIndex - 1);
            sort(arr, pivotIndex + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int l = left + 1;
        int r = right;
        while (l < r) {
            while (l < right && arr[l] < pivot) {
                l++;
            }
            while (r > left && arr[r] >= pivot) {
                r--;
            }
            if (l < r) {
                // Swap arr[l] and arr[r]
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        if (arr[left] > arr[r]) {
            arr[left] = arr[r];
            arr[r] = pivot;
        }
        return r;
    }

    public static void main(String[] args) {
        int[] testArr = { 72, 11, 62, 23, 8, 85, 42, 212, 14, 23, 902, 2, 56, 23, 456, 766, 1, 3798, 2, 24, 657 };
        int[] alreadySorted = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21 };

        final int TIMES_TO_RUN = 10;
        long[] runTimes = new long[TIMES_TO_RUN];

        for (int i = 0; i < runTimes.length; i++) {
            long beforeTime = System.nanoTime();
            sort(testArr, 0, testArr.length - 1);
            long afterTime = System.nanoTime();
            runTimes[i] = afterTime - beforeTime;
        }

        for (int entry : testArr) {
            System.out.println(entry);
        }

        double avg = Arrays.stream(runTimes).average().getAsDouble();
        System.out.println("Average Time taken = " + avg + "ns");

        for (int i = 0; i < runTimes.length; i++) {
            long beforeTime = System.nanoTime();
            sort(alreadySorted, 0, alreadySorted.length - 1);
            long afterTime = System.nanoTime();
            runTimes[i] = afterTime - beforeTime;
        }

        for (int entry : alreadySorted) {
            System.out.println(entry);
        }

        double avg2 = Arrays.stream(runTimes).average().getAsDouble();
        System.out.println("Average Time taken = " + avg2 + "ns");

        // System.out.println("Quicksort completed in " + runTime + "ns.");
    }
}