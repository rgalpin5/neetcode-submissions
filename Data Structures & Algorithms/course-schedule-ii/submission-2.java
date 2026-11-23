class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        int[] ans = new int[numCourses];
        int coursesTaken = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] preq : prerequisites) {
            graph.get(preq[1]).add(preq[0]);
            indegree[preq[0]]++;
        }

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) queue.offer(i);
        }

        while(!queue.isEmpty()) {
            int currCourse = queue.poll();
            for(int course : graph.get(currCourse)) {
                indegree[course]--;
                if(indegree[course] == 0) queue.offer(course);
            }
            ans[coursesTaken++] = currCourse;
        }

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] > 0) return new int[]{};
        }

        return ans;
    }
}
