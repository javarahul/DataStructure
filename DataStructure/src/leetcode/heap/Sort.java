class Sort {
    private void swap(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private void heapify(int[] pq, int k, int n) {
        int largest = k;
        int l = 2 * k + 1;
        int r = 2 * k + 2;
        if (l < n && pq[l] > pq[largest])
            largest = l;
        if (r < n && pq[r] > pq[largest])
            largest = r;
        if (largest != k) {
            swap(pq, k, largest);
            heapify(pq, largest, n);
        }
    }

    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int k = n / 2 - 1; k >= 0; k--)
            heapify(nums, k, n);
        for (int k = n - 1; k > 0; k--) {
            swap(nums, 0, k);
            heapify(nums, 0, k);
        }
        return nums;
    }
}
