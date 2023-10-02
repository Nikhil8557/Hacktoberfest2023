// Optimization of Mid Calculation:
// Instead of calculating the mid-point as (si + ei) / 2, which could potentially
// result in an integer overflow for very large arrays, we calculate it as
// si + (ei - si) / 2. This avoids the overflow issue.

// Main merge sort function to sort arr
public static void mergeSort(int[] arr) {
    // Call the helper function with initial start and end indices
    mergeSort(arr, 0, arr.length - 1);
}

// Helper function 1
// si - start index
// ei - end index
public static void mergeSort(int[] arr, int si, int ei) {
    // Check if there's only one element in the current subarray
    if (ei - si == 0) {
        return; // Return immediately as it's already sorted
    }

    // Calculate the middle index of the subarray
    int mid = (si + ei) / 2;

    // Recursively sort the left and right halves of the subarray
    mergeSort(arr, si, mid);
    mergeSort(arr, mid + 1, ei);

    // Merge the sorted halves
    merge(arr, si, mid, ei);
}

// Helper function 2
private static void merge(int[] arr, int si, int mid, int ei) {
    // Avoid Unnecessary Recursion:
    // Check if there's only one element in the current subarray.
    if (si >= ei) {
        return; // Return immediately as there's nothing to merge
    }

    // Initialize indices and a temporary array
    int i = si, j = mid + 1;
    int k = 0;
    int[] temp = new int[ei - si + 1];

    // Merge the two sorted subarrays into the temporary array
    while (i <= mid && j <= ei) {
        if (arr[i] <= arr[j]) {
            temp[k] = arr[i];
            k++;
            i++;
        } else {
            temp[k] = arr[j];
            k++;
            j++;
        }
    }

    // Copy any remaining elements from the left subarray, if any
    while (i <= mid) {
        temp[k] = arr[i];
        k++;
        i++;
    }

    // Copy any remaining elements from the right subarray, if any
    while (j <= ei) {
        temp[k] = arr[j];
        k++;
        j++;
    }

    // Copy the merged elements back to the original array
    for (int t = 0; t < temp.length; t++) {
        arr[t + si] = temp[t];
    }
}
