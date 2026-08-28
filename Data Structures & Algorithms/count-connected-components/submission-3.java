class Solution {
    public int countComponents(int n, int[][] edges) {
        // Step 1: Build the adjacency list to represent the graph.
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // Step 2: Keep track of visited nodes and the component count.
        boolean[] visited = new boolean[n];
        int componentCount = 0;


        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                componentCount++;
                // Start a DFS to find and mark all nodes in this component.
                dfs(i, adj, visited);
            }
        }

        return componentCount;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;

        for(int neighbor : adj.get(node)) {
            if(!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }
}
