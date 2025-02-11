// Java program for Merge Sort
class MergeSort
 {
    // Merges two subarrays of a[]
    void merge(int a[], int l, int m, int r)
    {

          int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = a[l + i];

          for (int j = 0; j < n2; ++j)
            R[j] = a[m + 1 + j];

        // Merge the temp arrays
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) 
        {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            }
            else {
                a[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) 
        {
            a[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) 
        {
            a[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts a[l..r] using
    // merge()
    void sort(int a[], int l, int r)
    {
        if (l < r) {
          
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(a, l, m);
            sort(a, m + 1, r);

            // Merge the sorted halves
            merge(a, l, m, r);
        }
    }

    // Driver method
    public static void main(String args[])
    {
        int a[] = {4,5,3,8,9,11,10  };

        // Calling of Merge Sort
        MergeSort ob = new MergeSort();
        ob.sort(a, 0, a.length - 1);

        int n = a.length;
        for (int i = 0; i < n; ++i)
            System.out.print(a[i] + " ");
    }
}
// **Time Complexity Analysis of Merge Sort:**
// Consider the following terminologies:
// T(k) = time taken to sort k elements
// M(k) = time taken to merge k elements
//  So, it can be written
//  T(N) = 2 * T(N/2) + M(N)
// = 2 * T(N/2) + constant * N
//  These N/2 elements are further divided into two halves. So,
//  T(N) = 2 * [2 * T(N/4) + constant * N/2] + constant * N
// = 4 * T(N/4) + 2 * N * constant
// . . .
// = 2k * T(N/2k) + k * N * constant
//  It can be divided maximum until there is one element left. So, then N/2k = 1. k = log2N
//  T(N) = N * T(1) + N * log2N * constant
// = N + N * log2N
//  Therefore the time complexity is O(N * log2N).
// So in the best case, the worst case and the average case the time complexity is the same.


//  **Space Complexity Analysis of Merge Sort:**
// Merge sort has a space complexity of O(n).
// This is because it uses an auxiliary array of size n to merge the sorted halves of the input array. The auxiliary array is used to store the merged result, and the input array is overwritten with the sorted result.


