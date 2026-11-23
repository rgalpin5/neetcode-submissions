class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freqs = new int[26];
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        Deque<int[]> queue = new ArrayDeque<>();
        for(char c : tasks) {
            freqs[c - 'A']++;
        }

        for(int i = 0; i < freqs.length; i++) {
            if(freqs[i] > 0) {
                heap.offer(freqs[i]);
            }
        }

        int time = 0;

        while(!heap.isEmpty() || !queue.isEmpty()) {
            time++;
            if(!heap.isEmpty()) {
                int currInterval = heap.poll();
                if(currInterval > 1) {
                    queue.offer(new int[]{currInterval - 1, time + n});
                }
            }
            /*

            time = 2
            queue = [[1,3],[1,4]]
            heap = []
            currInterval = 2


            */
            if(!queue.isEmpty() && queue.peek()[1] == time) {
                int[] task = queue.poll();
                heap.offer(task[0]);
            }
        }

        return time;
    }
}
