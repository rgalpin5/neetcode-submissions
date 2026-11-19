class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        int[] visits = new int[numCourses];
        for(int[] course : prerequisites) {
            adj.computeIfAbsent(course[0], k -> new ArrayList<>()).add(course[1]);
        }
        for(int i = 0; i < numCourses; i++) {
            if(hasCycle(adj, i, visits)) return false;
        }
        return true;
    }

    public static boolean hasCycle(HashMap<Integer, List<Integer>> adj, int currCourse, int[] visits) {
        if(visits[currCourse] == 2) return false;
        else if(visits[currCourse] == 1) return true;
        else {
            visits[currCourse] = 1;
            if(adj.get(currCourse) != null) {
                for(int course : adj.get(currCourse)) {
                    if(hasCycle(adj, course, visits)) return true;
                }
            }
            visits[currCourse] = 2;
        }
        return false;
    }
}
