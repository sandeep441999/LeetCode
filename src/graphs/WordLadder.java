package graphs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Pair {
    String word;
    int steps;

    public Pair(String word, int steps) {
        this.word = word;
        this.steps = steps;
    }

}

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // int steps = 0;
        // ArrayDeque<String> q = new ArrayDeque<>();
        // q.offer(beginWord);
        // HashSet<String> set = new HashSet<>();
        // set.add(beginWord);
        // int len = beginWord.length();

        // while(!q.isEmpty()) {

        // int size = q.size();
        // steps++;

        // for(int x=0; x<size; x++) {
        // String prev = q.poll();

        // if(prev.equals(endWord)) return steps;

        // for(String cur : wordList) {
        // int count = 0;
        // if(set.contains(cur)) continue;
        // for(int i=0; i<len; i++) {
        // if(prev.charAt(i) != cur.charAt(i)) count++;
        // }

        // if(count == 1) {
        // q.offer(cur);
        // set.add(cur);
        // }
        // }
        // }

        // }

        // return 0;

        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(beginWord, 1));

        Set<String> set = new HashSet<>(wordList);

        set.remove(beginWord);

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            String prev = pair.word;
            int steps = pair.steps;

            if (prev.equals(endWord))
                return steps;

            for (int i = 0; i < prev.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] chars = prev.toCharArray();
                    chars[i] = ch;
                    String cur = new String(chars);
                    if (set.contains(cur)) {
                        q.offer(new Pair(cur, steps + 1));
                        set.remove(cur);
                    }
                }
            }
        }

        return 0;
    }
}
