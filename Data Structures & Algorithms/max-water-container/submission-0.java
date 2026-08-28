class Solution {
    public int maxArea(int[] heights) {
        int tempArr = 0;
        int maxArr = 0; 
        int l = 0;
        int r = heights.length - 1;

        while(l < r){
            tempArr = Math.min(heights[l], heights[r]) * (r-l);
            maxArr = Math.max(maxArr, tempArr);
            if(heights[l] == heights[r]){
                if(heights[r-1]>heights[l+1]){
                    r--;
                }
                else{
                    l++;
                }
            }
            else if(heights[l] > heights[r]){
                r--;
            }
            else{
                l++;
            }
        }
        return maxArr;
    }
}
