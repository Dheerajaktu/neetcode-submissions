class Solution {

    /* Approach:: 
    Basically we need to find max area where we can store max water in b/w vertical lines or poles.   
    So we will that min vertical pol between two becuase water will fill till min height only.
    So that's we will take height = Math.min(height[i], height[j]);
    Then we can find width simply find the diff b/w distance of two verticla poles.
    width = point of j = point of i;
    then we will find area using formula 
    Area = Widh * Height;
    And will store max area;
    And finallly our max Area would be container or empty area where we can store max water.
    so we found our answer. 
    HaPpY LeArNiNg!
    */
    public int maxArea(int[] heights) {
        int n = heights.length; 
        int i = 0; 
        int j = n-1;
        int maxWaterContainer = 0;

        while(i < j){
            int w = j - i; // w ==> width

            int h = Math.min(heights[i], heights[j]); // taking least height from both

            int area = w * h;

            maxWaterContainer = Math.max(maxWaterContainer, area);

            if(heights[i] > heights[j]){
                j--;
            }else{
                i++;
            }
        }

        return maxWaterContainer;
    }
}
