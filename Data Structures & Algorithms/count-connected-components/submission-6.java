class Solution {
    public int countComponents(int n, int[][] edges) {
        if(edges.length == 0) return n;
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        int count = 0;
        for(int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        HashSet<Integer> visited = new HashSet<>();

        for(int i = 0; i < n; i++) {
            if(visited.contains(i)) continue;
            else{
                dfs(i, visited, adj);
                count++;
            }
        }
        return count;
    }

    private void dfs(int node, HashSet<Integer> visited, HashMap<Integer, List<Integer>> adj) {
        visited.add(node);
        if(!adj.containsKey(node)) return;
        for(int nei : adj.get(node)) {
            if(!visited.contains(nei)) {
                dfs(nei, visited, adj);
            }
        }
    }
}
