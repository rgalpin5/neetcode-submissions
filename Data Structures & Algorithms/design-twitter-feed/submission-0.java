class Twitter {
    private HashMap<Integer, Set<Integer>> followers;
    private HashMap<Integer, LinkedList<int[]>> posts;
    private int postCount;

    public Twitter() {
        followers = new HashMap<>();
        posts = new HashMap<>();
        postCount = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        createUserIfNotExist(userId);
        posts.get(userId).addFirst(new int[]{postCount++, tweetId});
            
    }
    
    public List<Integer> getNewsFeed(int userId) {
        createUserIfNotExist(userId);

        // BUG FIX 1: The heap must be a local variable.
        // It keeps the 10 posts with the largest timestamps.
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        
      
        // Add posts from followees.
        for (int followeeId : followers.get(userId)) {
            if (posts.containsKey(followeeId)) {
                // BUG FIX 2: Get posts from the followeeId, not userId.
                for (int[] post : posts.get(followeeId)) {
                    minHeap.offer(post);
                }
            }
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        maxHeap.addAll(minHeap);
        List<Integer> feed = new ArrayList<>();
        while(!maxHeap.isEmpty() && feed.size() < 10) {
            feed.add(maxHeap.poll()[1]);
        }
        
        return feed;

        
    }
    
    public void follow(int followerId, int followeeId) {
        createUserIfNotExist(followerId);
        createUserIfNotExist(followeeId);
        followers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        createUserIfNotExist(followerId);
        createUserIfNotExist(followeeId);
        // A user cannot unfollow themselves.
        if (followerId != followeeId) {
            followers.get(followerId).remove(followeeId);
        }
    }

    private void createUserIfNotExist(int userId) {
        followers.putIfAbsent(userId, new HashSet<>());
        // A user always follows themselves.
        followers.get(userId).add(userId);
        posts.putIfAbsent(userId, new LinkedList<>());
    }
}
