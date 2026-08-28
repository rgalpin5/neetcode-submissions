class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] prereq : prerequisites) {
            graph.computeIfAbsent(prereq[0], k -> new ArrayList<>()).add(prereq[1]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] overallVisited = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(!containsCycle(graph, i, visited, overallVisited)) return false;
        }
        for(boolean val : overallVisited) {
            if(!val) return false;
        }
        return true;

    }
    /*
    numCourses = 4
    prereqs = [[2,1][3,0][3,2]]



    */
    private boolean containsCycle(HashMap<Integer, List<Integer>> graph, int course, boolean[] visited, boolean[] overallVisited) {
        if(overallVisited[course]) return true;
        if(visited[course]) return false;
        if(!graph.containsKey(course)){
            overallVisited[course] = true;
            return true;
        }
        visited[course] = true;
        for(int prereq : graph.get(course)) {
            if(!containsCycle(graph, prereq, visited, overallVisited)) return false;
        }
        visited[course] = false;
        overallVisited[course] = true;
        return true;
    }
}
