class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> freqMap = new HashMap<>();

        for(String str : strs) {
            int[] freqs = new int[26];
            for(char c : str.toCharArray()) {
                freqs[c - 'a']++;
            }
            String key = Arrays.toString(freqs);
            freqMap.putIfAbsent(key, new ArrayList<>());
            freqMap.get(key).add(str);
        }

        return new ArrayList<>(freqMap.values());
    }
}
