class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqs = new HashMap<>();
        
        for(int num : nums) {
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer>[] buckets = new ArrayList[nums.length + 1];
        int[] ans = new int[k];
        for(int i = 0; i <= nums.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for(int num : freqs.keySet()) {
            buckets[freqs.get(num)].add(num);
        }
        int kIndex = 0;
        for(int i = nums.length; i >= 0; i--) {
            for(int num : buckets[i]) {
                ans[kIndex++] = num;
                if(kIndex == k) return ans;
            }
        }
        return ans;
    }
}
