class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        int currNum = n;
        while(!seen.contains(currNum) && currNum != 1) {
            seen.add(currNum);
            int newNum = 0;
            while(currNum != 0) {
                newNum += Math.pow(currNum % 10, 2);
                currNum /= 10;
            }
            currNum = newNum;
            
        }
        if(seen.contains(currNum)) return false;
        return true;
    }
}
