class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, List<String>> adjacency = new HashMap<>();

        for (List<String> ticket : tickets) {
            adjacency.computeIfAbsent(ticket.get(0), k -> new ArrayList<>()).add(ticket.get(1));
        }

        for(String airport : adjacency.keySet()) {
            Collections.sort(adjacency.get(airport));
        }

        ArrayList<String> ans = new ArrayList<>();
        ans.add("JFK");

        if(dfs(adjacency, "JFK", ans, tickets.size()+1)) {
            return ans;
        }

        return new ArrayList<>();
        
    }
    //{HOU -> {JFK}, SEA -> {JFK}, JFK -> {HOU, SEA}}
    //["HOU","JFK"],
    //["SEA","JFK"],
    //["JFK","SEA"],
    //["JFK","HOU"]
    private boolean dfs(HashMap<String, List<String>> adjacency, String src, List<String> ans, int targetLen) {
        
        if (ans.size() == targetLen) return true;

        if (!adjacency.containsKey(src)) return false;

        List<String> temp = new ArrayList<>(adjacency.get(src));

        

        for (int i = 0; i < temp.size(); i++) {
            String v = temp.get(i);
            adjacency.get(src).remove(i);
            ans.add(v);
            if(dfs(adjacency, v, ans, targetLen)) return true;
            adjacency.get(src).add(i, v);
            ans.remove(ans.size() - 1);
        }

        return false;
    }
}
