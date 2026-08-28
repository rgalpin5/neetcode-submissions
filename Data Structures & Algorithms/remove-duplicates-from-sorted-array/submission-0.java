class Solution {
    public int removeDuplicates(int[] nums) {
        ArrayList<Integer> uniqueNums = new ArrayList<>();
        int k = 0;
        for(int num : nums){
            if(!uniqueNums.contains(num)){
                uniqueNums.add(num);
                k++;
            }
            else{
                num = 0;
            }
        }
        for(int i = 0;i<uniqueNums.size();i++){
            nums[i] = uniqueNums.get(i);
        }
        return k;
    }
}