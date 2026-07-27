class Solution {
    public boolean hasDuplicate(int[] nums) {
        int len = nums.length;
        if(len == 1) return false;
        HashSet<Integer> set = new HashSet<>();
        /* TC: O(n) && SC: O(n) here */

        for(int num: nums){
            if(set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }

}