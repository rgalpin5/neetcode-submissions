class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        HashMap<String, List<String>> mutations = new HashMap<>();
        wordList.add(beginWord);
        for(String str : wordList) {
            for(int i = 0; i < str.length(); i++) {
                sb.append(str);
                sb.replace(i, i+1, "*");
                mutations.computeIfAbsent(sb.toString(), k -> (new ArrayList<>())).add(str);
                sb.delete(0, sb.length());
            }
        }
        System.out.println(mutations.toString());
        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);
        int ans = 0;
        int size = 0;
        while(!queue.isEmpty()) {
            ans++;
            size = queue.size();
            while(size > 0){
                String curr = queue.poll();
                for(int i = 0; i < curr.length(); i++) {
                    sb.append(curr);
                    sb.replace(i, i+1, "*");
                    if(mutations.containsKey(sb.toString()) && !visited.contains(sb.toString())) {
                        for(String s : mutations.get(sb.toString())){
                            System.out.println(s);
                            System.out.println(ans);
                            if(s.equals(endWord)) return ans + 1;
                            queue.offer(s);
                        }
                    }
                    visited.add(sb.toString());
                    sb.delete(0, sb.length());
                }
                size--;
            }
            
        }
        return 0;
    }
}
