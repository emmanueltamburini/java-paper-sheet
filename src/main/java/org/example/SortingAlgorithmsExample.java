package org.example;

import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithmsExample {
    private static final int ARRAY_SIZE = 10000;
    private static final int MAX_VALUE = 10000;

    public void run() {
            System.out.println("Sorting Algorithms Examples in Java:");

        int[] originalArray = generateRandomArray(ARRAY_SIZE, MAX_VALUE);

        bubbleSort(Arrays.copyOf(originalArray, originalArray.length));
        selectionSort(Arrays.copyOf(originalArray, originalArray.length));
        insertionSort(Arrays.copyOf(originalArray, originalArray.length));
        mergeSort(Arrays.copyOf(originalArray, originalArray.length));
        quickSort(Arrays.copyOf(originalArray, originalArray.length));
        heapSort(Arrays.copyOf(originalArray, originalArray.length));
        countingSort(Arrays.copyOf(originalArray, originalArray.length));
        radixSort(Arrays.copyOf(originalArray, originalArray.length));
    }

    private int[] generateRandomArray(int size, int maxValue) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(maxValue + 1);
        }
        return array;
    }

    private void bubbleSort(int[] arr) {
        System.out.println("\n*********************** Bubble Sort ***********************");
        System.out.println("Explanation: Repeatedly steps through the list, compares adjacent elements and swaps them if they are in the wrong order.");
        System.out.println("Pros: Simple to understand and implement.");
        System.out.println("Cons: Very inefficient for large lists, O(n^2) time complexity.");
        System.out.println("Best used when: The list is small and nearly sorted. It's also useful for educational purposes due to its simplicity.");

        long startTime = System.nanoTime();

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        long endTime = System.nanoTime();
        System.out.println("Bubble Sort execution time: " + (endTime - startTime) / 1000000 + " ms");
    }

    private void selectionSort(int[] arr) {
        System.out.println("\n*********************** Selection Sort ***********************");
        System.out.println("Explanation: Divides the input list into two parts: sorted and unsorted. Repeatedly selects the smallest element from the unsorted portion and adds it to the sorted portion.");
        System.out.println("Pros: Simple to implement, performs well on small lists.");
        System.out.println("Cons: Inefficient for large lists, O(n^2) time complexity.");
        System.out.println("Best used when: The list is small and minimizing memory usage is a priority, as it makes the minimum number of swaps.");

        long startTime = System.nanoTime();

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }

        long endTime = System.nanoTime();
        System.out.println("Selection Sort execution time: " + (endTime - startTime) / 1000000 + " ms");
    }

    private void insertionSort(int[] arr) {
        System.out.println("\n*********************** Insertion Sort ***********************");
        System.out.println("Explanation: Builds the final sorted array one item at a time. It iterates through the input elements, growing the sorted array with each iteration.");
        System.out.println("Pros: Simple to implement, efficient for small data sets, adaptive (efficient for data sets that are already substantially sorted).");
        System.out.println("Cons: Inefficient for large lists, O(n^2) time complexity.");
        System.out.println("Best used when: The array is small or nearly sorted. It's also useful when elements are being added one at a time to an already sorted list.");

        long startTime = System.nanoTime();

        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

        long endTime = System.nanoTime();
        System.out.println("Insertion Sort execution time: " + (endTime - startTime) / 1000000 + " ms");
    }

    private void mergeSort(int[] arr) {
        System.out.println("\n*********************** Merge Sort ***********************");
        System.out.println("Explanation: Divides the unsorted list into n sublists, each containing one element, then repeatedly merges sublists to produce new sorted sublists until there is only one sublist remaining.");
        System.out.println("Pros: Efficient for large data sets, stable sort, O(n log n) time complexity.");
        System.out.println("Cons: Requires additional memory space for merging.");
        System.out.println("Best used when: You need a stable, efficient sort for large data sets, especially when dealing with linked lists. It's also preferred when predictable performance is required, as it has a consistent O(n log n) time complexity.");

        long startTime = System.nanoTime();

        mergeSortHelper(arr, 0, arr.length - 1);

        long endTime = System.nanoTime();
        System.out.println("Merge Sort execution time: " + (endTime - startTime) / 1000000 + " ms");
    }

    private void mergeSortHelper(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSortHelper(arr, l, m);
            mergeSortHelper(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, m + 1, R, 0, n2);
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    private void quickSort(int[] arr) {
        System.out.println("\n*********************** Quick Sort ***********************");
        System.out.println("Explanation: Selects a 'pivot' element and partitions the other elements into two sub-arrays according to whether they are less than or greater than the pivot.");
        System.out.println("Pros: Very efficient for large data sets, O(n log n) average time complexity.");
        System.out.println("Cons: Worst case time complexity of O(n^2), not stable.");
        System.out.println("Best used when: You need an efficient, in-place sorting algorithm for large data sets. It's particularly effective when the input array is in random order.");

        long startTime = System.nanoTime();

        quickSortHelper(arr, 0, arr.length - 1);

        long endTime = System.nanoTime();
        System.out.println("Quick Sort execution time: " + (endTime - startTime) / 1000000 + " ms");
    }

    private void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSortHelper(arr, low, pi - 1);
            quickSortHelper(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    private void heapSort(int[] arr) {
        System.out.println("\n*********************** Heap Sort ***********************");
        System.out.println("Explanation: Creates a max-heap from the array and repeatedly extracts the maximum element from the heap.");
        System.out.println("Pros: Efficient for large data sets, O(n log n) time complexity, in-place sorting.");
        System.out.println("Cons: Not stable, poor cache performance.");
        System.out.println("Best used when: You need an efficient, in-place sorting algorithm with guaranteed O(n log n) performance. It's particularly useful when memory usage is a concern.");

        long startTime = System.nanoTime();

        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }

        long endTime = System.nanoTime();
        System.out.println("Heap Sort execution time: " + (endTime - startTime) / 1000000 + " ms");
    }

    private void heapify(int[] arr, int n, int i) {
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

    private void countingSort(int[] arr) {
        System.out.println("\n*********************** Counting Sort ***********************");
        System.out.println("Explanation: Works by counting the number of objects having distinct key values, then doing arithmetic to calculate the position of each object in the output sequence.");
        System.out.println("Pros: Efficient for small range of input values, O(n+k) time complexity where k is the range of input.");
        System.out.println("Cons: Not suitable when the range of input values is large compared to the number of elements.");
        System.out.println("Best used when: The range of potential values is known and is not significantly larger than the number of elements. It's particularly efficient for sorting integers or characters.");

        long startTime = System.nanoTime();

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];
        for (int j : arr) {
            count[j - min]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
        System.arraycopy(output, 0, arr, 0, arr.length);

        long endTime = System.nanoTime();
        System.out.println("Counting Sort execution time: " + (endTime - startTime) / 1000000 + " ms");
    }

    private void radixSort(int[] arr) {
        System.out.println("\n*********************** Radix Sort ***********************");
        System.out.println("Explanation: Sorts the elements by first grouping the individual digits of the same place value. Then, sort the elements according to their increasing/decreasing order.");
        System.out.println("Pros: Efficient for integers or strings with fixed-size, O(nk) time complexity where k is the number of digits.");
        System.out.println("Cons: Requires additional memory space, not suitable for floating-point numbers.");
        System.out.println("Best used when: Sorting integers or strings with fixed-length and a relatively small number of digits or characters. It's particularly efficient when the range of possible digits is small.");

        long startTime = System.nanoTime();

        int max = Arrays.stream(arr).max().getAsInt();
        for (int exp = 1; max / exp > 0; exp *= 10)
            countingSortByDigit(arr, exp);

        long endTime = System.nanoTime();
        System.out.println("Radix Sort execution time: " + (endTime - startTime) / 1000000 + " ms");
    }

    private void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);
        for (int j : arr) count[(j / exp) % 10]++;
        for (int i = 1; i < 10; i++) count[i] += count[i - 1];
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        System.arraycopy(output, 0, arr, 0, n);
    }
}