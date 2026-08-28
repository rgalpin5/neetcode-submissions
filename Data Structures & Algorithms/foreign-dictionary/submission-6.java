class Solution {
    public String foreignDictionary(String[] words) {
        HashMap<Character, List<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();
        for(String str : words){
            for(char c : str.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for(int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];
            int strLen = Math.min(w1.length(), w2.length());
            boolean foundDifference = false;
            for (int j = 0; j < strLen; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    indegree.put(c2, indegree.get(c2) + 1);
                    foundDifference = true;
                    break; // Found the first difference, move to the next pair of words
                }
            }

            // After the loop, check for the invalid prefix case
            if (!foundDifference && w1.length() > w2.length()) {
                return ""; // e.g., ["abc", "ab"] is an invalid order
            }
        }
        System.out.println(indegree.toString() + " " + graph.toString());
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        HashSet<Character> appended = new HashSet<>();

        for(char c : indegree.keySet()) {
            if(indegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        while(!queue.isEmpty()) {
            char currChar = queue.poll();
            sb.append(currChar);
            if(graph.containsKey(currChar)){
                for(char ch : graph.get(currChar)) {
                    indegree.put(ch, indegree.get(ch) - 1);
                    if(indegree.get(ch) == 0){
                        queue.offer(ch);
                    }
                }
            }
        }
        if (sb.length() == indegree.size()) {
            return sb.toString();
        }
        return ""; 
    }
}
