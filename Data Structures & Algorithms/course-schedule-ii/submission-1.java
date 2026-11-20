class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }
        for(int[] course : prerequisites) {
            adj.get(course[1]).add(course[0]);
            indegree[course[0]]++;
        }

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int outIdx = 0;
        while(!queue.isEmpty()) {
            int course = queue.poll();
            ans[outIdx++] = course;
            for(int c : adj.get(course)) {
                indegree[c]--;
                if(indegree[c] == 0) queue.offer(c);
            }
        }
        for(int num : indegree) {
            if (num > 0) return new int[0];
        }

        return ans;

    }
}
