class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> preqMap = new HashMap<>();
        for(int i = 0; i < numCourses; i++) {
            preqMap.put(i, new ArrayList<>());
        }
        for(int[] pair : prerequisites) {
            preqMap.get(pair[0]).add(pair[1]);
        }

        HashSet<Integer> visited = new HashSet<>();
        for(int i = 0; i < numCourses; i++) {
            if(!dfs(visited, preqMap, i)) return false;
        }
        return true;
    }

    private boolean dfs(HashSet<Integer> visited, HashMap<Integer, List<Integer>> preqMap, int currCourse) {
        if(visited.contains(currCourse)) return false;
        if(preqMap.get(currCourse).isEmpty()) return true;

        visited.add(currCourse);

        for(int course : preqMap.get(currCourse)) {
            if(!dfs(visited, preqMap, course)){
                return false;
            }
        }

        visited.remove(currCourse);
        return true;
    }
}
