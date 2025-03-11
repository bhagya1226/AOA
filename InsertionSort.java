public class InsertionSort {

    // Method to perform insertion sort
    public static void insertionSort(int[] arr) {
        // Iterate through the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];  // The element to be inserted into the sorted portion of the array
            int j = i - 1;

            // Shift elements of the sorted portion that are greater than the key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            // Insert the key at the correct position
            arr[j + 1] = key;
        }
    }

    // Method to print the array
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Driver method
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};

        System.out.println("Original Array:");
        printArray(arr);

        // Call insertionSort to sort the array
        insertionSort(arr);

        System.out.println("Sorted Array:");
        printArray(arr);
    }
}
