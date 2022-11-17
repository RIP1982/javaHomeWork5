/* Реализовать алгоритм пирамидальной сортировки (HeapSort).
 */


import java.util.Random;
import java.util.logging.Logger;

public class Task3 {
    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        int arr[] = fillArray();
        logger.info("Original array: " + arrToString(arr));
        sort(arr);
        logger.info("Sorted array is: " + "{" + arrToString(arr) + "}");
    }

    static int [] fillArray() {
        Random rnd = new Random();
        int[] arr = new int[rnd.nextInt(5, 15)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(0, 101);
        }
        return arr;
    }

    static void sort(int arr[]) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    static void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    static String arrToString(int arr[]) {
        String arrToString = "";
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            arrToString += arr[i] + " ";
        return arrToString + arr[n-1];
    }
}

