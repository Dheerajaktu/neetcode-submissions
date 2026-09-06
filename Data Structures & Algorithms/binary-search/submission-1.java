class Solution {
    public int search(int[] nums, int target) {
        /*
        Rule for Binray Search:: Data should be sorted order!
        Time Complexity:: O(n log n)
        Space Complexity:: O(1)
        So, Binary search is more optimise way to search data in sorted list, because it check middle element and decide target go left/right conditonally.
        In Linear search in worst case you can go up to n-numbers travsersal.
        @Author:: DS!

        */

        int n = nums.length;
        int left = 0;
        int right = n-1;
        
        while(left <= right){

            int mid = left + (right - left)/2;

            if(nums[mid] == target) return mid;

            if(nums[mid] < target) {
                left = mid + 1;
            }else{
              right = mid - 1;
            }
        }

        return -1;
    }
}
