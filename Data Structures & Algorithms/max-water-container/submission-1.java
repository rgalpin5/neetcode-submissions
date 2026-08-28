class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int maxHeight = 0;   
        //[1,7,2,5,4,7,3,6]
        //l = 0
        //r = 7
        //maxHeight = 0;
        //distance
        while(l < r) {
            int distance = r - l;
            if(heights[l] < heights[r]) {
                maxHeight = Math.max(heights[l] * distance, maxHeight);
                l++;
            }
            else if(heights[l] > heights[r]) {
                maxHeight = Math.max(heights[r] * distance, maxHeight);
                r--;
            }
            else {
                maxHeight = Math.max(heights[l] * distance, maxHeight);
                if(heights[l+1] > heights[r-1]) {
                    l++;
                }
                else r--;
            }
        }

        return maxHeight;
    }
}
