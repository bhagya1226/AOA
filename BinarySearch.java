
class BinarySearch {
    int binarySearch(int a[], int l, int r, int x)
    {
        // Scanner sc=new Scanner(System.in);
        // System.out.println("Enter Element Of array:   ");
        // int a[]=sc.nexta();
        // System.out.println("Enter Element To be search:  ");
        // int x=sc.nextInt();
        while (l <= r)
        {
            int m = (l + r) / 2;
            if (a[m] == x)
            {
                return m;
            // If element is smaller than mid, then
            // it can only be present in left subarray
            // so we decrease our r pointer to mid - 1 
            } 
            else if (a[m] > x) 
            {
                r = m - 1;
            // Else the element can only be present
            // in right subarray
            // so we increase our l pointer to mid + 1
            } 
            else
             {
              l = m + 1;
            }  
        }

        // No Element Found
        return -1;
    }
    public static void main(String args[])
    {
        BinarySearch ob = new BinarySearch();
        int a[] = { 2, 3, 4, 10, 40 };
        int n = a.length;
        int x = 4;
      
        int res = ob.binarySearch(a,0, n - 1, x);

        if (res == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + res);
    }
}
Output:-
Element found at index 2

    
//**Time Complexity** 
1. Best Case (O(1)): In the best-case scenario, binary search finds the target value immediately at the mid-point of the array.
    This requires only a single comparison, making the time complexity O(1). 
    The algorithm achieves its optimal performance when the target is perfectly aligned with the mid-point on the first attempt.
2. Average Case (O(log n)): On average, binary search performs O(log n) comparisons. 
    Each step halves the search range, leading to logarithmic time complexity. 
    This efficiency holds across various positions of the target within the sorted array, as the algorithm consistently reduces the problem size exponentially.
3. Worst Case (O(log n)): In the worst-case scenario, binary search also operates with O(log n) complexity.
    This occurs when the target value is not present, requiring the algorithm to explore the entire search range.
    Despite this, the logarithmic reduction of the search space ensures that the time complexity remains logarithmic.
**Space Complexity **
   1. O(1) (iterative version) 
   2.O(logn) (recursive version)
‍
    
