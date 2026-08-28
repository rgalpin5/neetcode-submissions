class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 0) {
            return 0;
        }

        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(a[0], b[0]));
        for(int[] car : cars){
            System.out.println(car[0] + " " + car[1]);
        }


        Stack<Double> stack = new Stack<>();
        for(int i = n - 1; i >= 0; i--){
            double arrivalTime = (double)(target - cars[i][0])/cars[i][1];
            System.out.println(arrivalTime);
            if (stack.isEmpty() || arrivalTime > stack.peek()) {
                stack.push(arrivalTime);
            }
        }
        return stack.size();
    }
    
}
