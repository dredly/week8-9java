import java.util.Arrays;

class MergeSort {
    public static void merge(int[] left_arr, int[] right_arr, int[] arr, int left_size, int right_size) {
        int left_current = 0;
        int right_current = 0;
        int arr_current = 0;
        while (left_current < left_size && right_current < right_size) {
            if (left_arr[left_current] <= right_arr[right_current]) {
                arr[arr_current] = left_arr[left_current];
                left_current++;
            } else {
                arr[arr_current] = right_arr[right_current];
                right_current++;
            }
            arr_current++;
        }
        while (left_current < left_size) {
            arr[arr_current] = left_arr[left_current];
            left_current++;
            arr_current++;
        }
        while (right_current < right_size) {
            arr[arr_current] = right_arr[right_current];
            right_current++;
            arr_current++;
        }
    }

    public static void mergeSort(int[] arr, int len) {
        if (len < 2) {
            return;
        }

        int midPoint = len / 2;
        int[] left = new int[midPoint];
        int[] right = new int[len - midPoint];

        for (int i = 0; i < midPoint; i++) {
            left[i] = arr[i];
        }
        for (int i = midPoint; i < len; i++) {
            right[i - midPoint] = arr[i];
        }

        mergeSort(left, midPoint);
        mergeSort(right, len - midPoint);
        merge(left, right, arr, midPoint, len - midPoint);
    }

    public static void main(String args[]) {
        int[] array = { 72, 11, 62, 23, 8, 85, 42, 212, 14, 23, 902, 2, 56, 23, 456, 766, 1, 3798, 2, 24, 657 };

        final int TIMES_TO_RUN = 10;
        long[] runTimes = new long[TIMES_TO_RUN];

        for (int i = 0; i < runTimes.length; i++) {
            long beforeTime = System.nanoTime();
            mergeSort(array, array.length);
            long afterTime = System.nanoTime();
            runTimes[i] = afterTime - beforeTime;
        }

        double avg = Arrays.stream(runTimes).average().getAsDouble();

        // for (int i = 0; i < array.length; ++i) {
        // System.out.print(array[i] + " ");
        // }

        System.out.println("Average Time taken = " + avg + "ns");
    }
}