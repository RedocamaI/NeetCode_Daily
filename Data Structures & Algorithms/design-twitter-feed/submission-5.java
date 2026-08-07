class Tweet {
    int tweetId;
    int time;

    public Tweet(int id, int time) {
        this.tweetId = id;
        this.time = time;
    }
}

class Twitter {
    Map<Integer, List<Tweet>> posts;
    Map<Integer, Map<Integer, Integer>> users;
    int clock;

    public Twitter() {
        this.posts = new HashMap<>();
        this.users = new HashMap<>();
        this.clock = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!this.posts.containsKey(userId)) {
            this.posts.put(userId, new ArrayList<>());
        }

        this.posts.get(userId).add(new Tweet(tweetId, this.clock+1));
        this.clock++;
    }

    private List<Integer> getTop10Feeds(PriorityQueue<Tweet> newsFeed) {
        int n = 0;
        List<Integer> top10Tweets = new ArrayList<>();

        while(!newsFeed.isEmpty() && n < 10) {
            top10Tweets.add(newsFeed.poll().tweetId);
            n++;
        }

        return top10Tweets;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> newsFeed = new PriorityQueue<>(
            (tweet1, tweet2) -> Integer.compare(tweet2.time, tweet1.time)
        );

        // get feeds from user herself:
        if(this.posts.containsKey(userId)) {
            for(Tweet tweet : posts.get(userId)) {
                newsFeed.offer(tweet);
            }
        }
        if(!this.users.containsKey(userId))
            return getTop10Feeds(newsFeed);

        // get user's followees:
        List<Integer> followees = new ArrayList<>();
        for(
            Map.Entry<Integer, Integer> followee : 
                this.users.get(userId).entrySet()
        ) {
            if(followee.getKey() == userId)
                continue;
            
            followees.add(followee.getKey());
        }

        // get the feeds of user's followees:
        for(Integer followee : followees) {
            if(!this.posts.containsKey(followee))
                continue;
            
            for(Tweet tweet : this.posts.get(followee)) {
                newsFeed.offer(tweet);
            }
        }

        return getTop10Feeds(newsFeed);
    }
    
    public void follow(int followerId, int followeeId) {
        if(!this.users.containsKey(followerId)) {
            this.users.put(followerId, new HashMap<>());
        }

        this.users.get(followerId).put(followeeId, 1);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!this.users.containsKey(followerId))
            return;
        
        this.users.get(followerId).remove(followeeId);

        // if the user doesn't follow anyone: remove it from users
        if(this.users.get(followerId).isEmpty()) {
            this.users.remove(followerId);
        }
    }
}
