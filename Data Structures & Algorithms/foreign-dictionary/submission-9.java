class Solution {
    public String foreignDictionary(String[] words) {
        int[] indegree = new int[26];
        HashMap<Character, List<Character>> graph = new HashMap<>();
        Deque<Character> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < words.length; i++) {
            for(char c : words[i].toCharArray()) {
                graph.computeIfAbsent(c, k -> new ArrayList<>());
            }
        }



        for(int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int charIdx = 0;
            while(charIdx < w1.length() && charIdx < w2.length() && w1.charAt(charIdx) == w2.charAt(charIdx)) {
                charIdx++;
            }
            
            if(charIdx == w1.length()) continue;
            if(charIdx >= w2.length()) return "";
            graph.get(w1.charAt(charIdx)).add(w2.charAt(charIdx));
            indegree[w2.charAt(charIdx) - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            if(indegree[i] == 0 && graph.containsKey(c)) {
                queue.offer(c);
            }
        }

        while(!queue.isEmpty()) {
            char currChar = queue.poll();
            sb.append(currChar);
            for(char c : graph.get(currChar)) {
                indegree[c - 'a']--;
                if(indegree[c - 'a'] == 0) queue.offer(c);
            }
        }
        if(sb.length() < graph.size()) return "";
        return sb.toString();
    }
}
