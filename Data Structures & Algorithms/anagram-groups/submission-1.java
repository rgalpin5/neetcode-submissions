class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        int index = 0;
        HashMap<String, List<String>> freqMap = new HashMap<>();

        for(String str : strs) {
            int[] freqs = new int[26];
            for(char c : str.toCharArray()){
                freqs[c - 'a']++;
            }
            StringBuilder keyBuilder = new StringBuilder();
            for(int freq : freqs){
                keyBuilder.append(freq).append('#');
            }

            freqMap.computeIfAbsent(keyBuilder.toString(), k -> new ArrayList<>()).add(str);

        }

        for(String key : freqMap.keySet()) {
            ans.add(freqMap.get(key));
        }
        return ans;
    }
}
