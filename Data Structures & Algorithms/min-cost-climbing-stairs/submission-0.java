class Solution {

    private HashMap<Integer, Integer> indexCost = new HashMap<>();

    public int minCostClimbingStairs(int[] cost) {
        return Math.min(costToGetTo(cost, cost.length-2),costToGetTo(cost, cost.length-1));
    }

    public int costToGetTo(int[] cost, int index){
        if(index == 0||index == 1){
            indexCost.put(index, cost[index]);
            return cost[index];
        }
        if(indexCost.containsKey(index)){
            return indexCost.get(index);
        }
        else{
            indexCost.put(index, cost[index]+Math.min(costToGetTo(cost, index-1), costToGetTo(cost, index-2)));
            return indexCost.get(index);
        }
    }
}
