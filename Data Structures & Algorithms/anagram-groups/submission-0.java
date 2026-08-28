class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> sigMap = new HashMap<>();
        List<List<String>> anagrams = new ArrayList<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String signature = new String(chars);

            sigMap.computeIfAbsent(signature, k -> new ArrayList<>()).add(str);
        }

        for(List<String> s : sigMap.values()){
            anagrams.add(s);
        }
        return anagrams;

    }
}
