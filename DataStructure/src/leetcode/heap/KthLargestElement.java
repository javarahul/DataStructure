class KthLargestElement {
    public static void main(String[] args){
      int arr[] = { 11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45 };
		  int k = 3;
		  int result = findKthLargest(arr, k);
      System.out.println("Kth Largest Element is:- " + result);
    }
    
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
        }
        
        int res = 0;
        for (int i = 0; i < k; i++){
            res = pq.poll();
        }
        
        return res;
    }
}
