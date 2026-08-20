package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class DesignTwitter {
    Map<Integer, User> userMap;
    private static int timeStamp = 0;

    private class Tweet {
        public int id;
        public int time;
        public Tweet next;

        public Tweet(int id) {
            this.id = id;
            this.time = timeStamp++;
            this.next = null;
        }
    }

    private class User {
        public int id;
        public Set<Integer> following;
        public Tweet tweet_head;

        public User(int id) {
            this.id = id;
            this.following = new HashSet<>();
            follow(id);
            this.tweet_head = null;
        }

        public void follow(int followeeId) {
            following.add(followeeId);
        }

        public void unFollow(int followeeId) {
            following.remove(Integer.valueOf(followeeId));
        }

        public void post(int tweetId) {
            Tweet temp = new Tweet(tweetId);
            temp.next = tweet_head;
            tweet_head = temp;
        }
    }

    public DesignTwitter() {
        userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userMap.computeIfAbsent(userId, k -> new User(userId)).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();

        if (!userMap.containsKey(userId))
            return res;

        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));

        // pq.offer(userMap.get(userId).tweet_head);

        Set<Integer> users = userMap.get(userId).following;

        for (int user : users) {
            Tweet tweet = userMap.get(user).tweet_head;
            if (tweet != null) {
                pq.offer(tweet);
            }
        }

        int n = 0;
        while (!pq.isEmpty() && n < 10) {
            Tweet t = pq.poll();

            res.add(t.id);
            n++;
            if (t.next != null) {
                pq.add(t.next);
            }

        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        userMap.computeIfAbsent(followerId, k -> new User(followerId));
        userMap.computeIfAbsent(followeeId, k -> new User(followeeId));
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId))
            return;
        userMap.get(followerId).unFollow(followeeId);
    }
}
