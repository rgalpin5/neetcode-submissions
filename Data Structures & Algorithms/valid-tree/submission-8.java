class Solution {
    HashSet<Integer> overallVisited = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        if(edges.length == 0) return true;
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        for(int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        if(graph.size() < n) return false;
        /*
        for(int i = 0; i < n; i++) {
            dfs(graph, visited, i);
            if(overallVisited.size() == n) return true;
        }
        */
        dfs(graph, visited, 0);
        visited = new HashSet<>();
        return(overallVisited.size() == n && allNodesAccessible(n, graph, visited));
    }

    private boolean dfs(HashMap<Integer, List<Integer>> graph, HashSet<Integer> visited, int currNode) {
        if(visited.contains(currNode)) return false;
        if(overallVisited.contains(currNode)) return true;

        if(graph.get(currNode).isEmpty()) {
            overallVisited.add(currNode); 
            return true;
        }

        visited.add(currNode);
        System.out.println(currNode + " " + visited.toString());
        for(int node : graph.get(currNode)) {
            graph.get(node).remove(Integer.valueOf(currNode));
            if(!dfs(graph, visited, node)) return false;
            graph.get(node).add(currNode);
        }

        visited.remove(currNode);
        overallVisited.add(currNode);
        return true;
    }

    private boolean allNodesAccessible(int n, HashMap<Integer, List<Integer>> graph, HashSet<Integer> visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while(!queue.isEmpty()) {
            if(visited.size() == n) return true;
            int currNode = queue.poll();
            visited.add(currNode);
            System.out.println(currNode + " " + visited.toString());
            for(int node : graph.get(Integer.valueOf(currNode))) {
                if(!visited.contains(node)) {
                    queue.offer(node);
                    visited.add(node);
                }
            }
        }
        return (visited.size() == n);

    }
}
