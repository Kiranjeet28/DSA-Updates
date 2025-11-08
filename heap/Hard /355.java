import java.util.*;

class Twitter {
    private HashMap<Integer, Set<Integer>> h1; // userId -> their tweets
    private HashMap<Integer, Set<Integer>> h2; // followerId -> followees
    private static int timeStamp = 0; // ✅ added: to track tweet order
    private HashMap<Integer, List<int[]>> tweets; // ✅ added: store (time, tweetId)

    public Twitter() {
        this.h1 = new HashMap<>();
        this.h2 = new HashMap<>();
        this.tweets = new HashMap<>(); // ✅ added
    }

    public void postTweet(int userId, int tweetId) {
        // ✅ changed: store tweets with timestamp to maintain order
        tweets.putIfAbsent(userId, new ArrayList<>()); // ✅ added
        tweets.get(userId).add(new int[] { timeStamp++, tweetId }); // ✅ added

        // Keeping your original logic (optional now)
        if (h1.containsKey(userId)) {
            Set<Integer> newSet = h1.get(userId);
            newSet.add(tweetId);
            h1.put(userId, newSet);
        } else {
            Set<Integer> newSet = new HashSet<>();
            newSet.add(tweetId);
            h1.put(userId, newSet);
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]); // ✅ changed type to store (time,
                                                                                   // tweetId)

      
        if (tweets.containsKey(userId)) {
            for (int[] t : tweets.get(userId)) {
                maxHeap.add(t);
            }
        }

       
        Set<Integer> follow = h2.get(userId);
        if (follow != null) {
            for (int followee : follow) {
                if (tweets.containsKey(followee)) {
                    for (int[] t : tweets.get(followee)) {
                        maxHeap.add(t);
                    }
                }
            }
        }

        // ✅ changed: only return latest 10 tweets
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            list.add(maxHeap.poll()[1]);
            count++;
        }

        return list;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId)
            return; // ✅ added: prevent self-follow
        if (h2.containsKey(followerId)) {
            Set<Integer> newSet = h2.get(followerId);
            newSet.add(followeeId);
            h2.put(followerId, newSet);
        } else {
            Set<Integer> newSet = new HashSet<>();
            newSet.add(followeeId);
            h2.put(followerId, newSet);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (h2.containsKey(followerId)) { // ⚠ fixed: prevent NullPointerException
            Set<Integer> newSet = h2.get(followerId);
            newSet.remove(followeeId);
            h2.put(followerId, newSet);
        }
    }

  
}
