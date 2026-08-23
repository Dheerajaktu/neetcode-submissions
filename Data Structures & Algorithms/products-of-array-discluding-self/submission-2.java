class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        /* SOLUTION ONE - */
        /* Accept Result --> 
        Memory: 77.6 MB - Time: 437ms - Submitted at: 08/23/2026 16:33
    
        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];
        //left to right
        left[0] = 1;
        for(int i = 1; i<n; i++){
            left[i] = left[i-1] * nums[i-1];
        }
        // right to left
        right[n-1] = 1;
        for(int i = n-2; i>=0; i--){
            right[i] = right[i + 1] * nums[i + 1];
        }
        // final result calculation
        for(int i = 0; i<n; i++){
            result[i] = left[i] * right[i];
        }
        return result;
        */

         /* SOLUTION TWO - More Optimised */
         // Memory: 75.2 MB - Time: 347ms - Submitted at: 08/23/2026 16:44
         int result [] = new int[n];
         //left to right product
          result[0] = 1;
         for(int i = 1; i<n; i++){
            result[i] = result[i-1] * nums[i-1];
         }

         int rightProduct = 1;

         //right to left product
         for(int i = n-1; i>=0; i--){
            result[i] = result[i] * rightProduct;
            rightProduct = nums[i] * rightProduct;
         }

         return result;
    }
}  
