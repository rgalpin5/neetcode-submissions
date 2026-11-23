class Solution {
    public String reorganizeString(String s) {
        int[] charFreqs = new int[26];
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));
        Deque<int[]> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            charFreqs[c - 'a']++;
            if(charFreqs[c - 'a'] > (s.length() + 1) / 2) return "";
        }

        for(int i = 0; i < 26; i++) {
            if(charFreqs[i] > 0) heap.offer(new int[]{charFreqs[i], i});
        }

        while(!heap.isEmpty()) {
            int[] curr = heap.poll();
            sb.append((char)(curr[1] + 'a'));
            int[] prev = stack.isEmpty() ? null : stack.pop();
            if(prev != null) heap.offer(prev);
            if(curr[0] > 1) {
                stack.push(new int[]{curr[0] - 1, curr[1]});
            }
        }

        return stack.isEmpty() ? sb.toString() : "";

    }
}