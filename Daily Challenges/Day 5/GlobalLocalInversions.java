/*
*Input: A = [1,0,2]
* Output: true
*/

class Solution {
    
    static int localInversions;
    static int globalInversions;
    
    public boolean isIdealPermutation(int[] A) {
        
        localInversions = 0;
        globalInversions = 0;
        
        // local Inversions
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1])
                localInversions++;
        }

        // global Inversions
        mergeSort(A, 0, A.length - 1);

        if (localInversions == globalInversions)
            return true;
        return false;
    }
    
     private void mergeSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    private void merge(int[] a, int low, int mid, int high) {
        int j = mid + 1;
        int start = low;
        int[] b = new int[high + 1];
        int k = 0;
        while (low <= mid && j <= high) {
            if (a[low] < a[j]) {
                b[k++] = a[low++];
            } else if (a[low] > a[j]) {
                b[k++] = a[j++];
               globalInversions += mid - low + 1;
            }
        }
        while (low <= mid) {
            b[k++] = a[low++];
        }
        while (j <= high) {
            b[k++] = a[j++];
        }

        for (int i = 0; i < k; i++)
            a[start + i] = b[i];
    }
}
