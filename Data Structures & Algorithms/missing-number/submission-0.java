class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int xOr = 0;
        for(int i = 0; i < nums.length + 1; i++){
            numSet.add(i);
            xOr = xOr ^ i;
        }
        System.out.println(xOr);

        

        for(int num : nums){
            xOr = xOr ^ num;
        }

        return xOr;
        
    }
}
