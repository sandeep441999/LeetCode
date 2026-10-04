package trie;

import java.util.ArrayList;
import java.util.Arrays;

class TrieNode {
    TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[2];
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(int num) {
        TrieNode cur = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (cur.children[bit] == null) {
                cur.children[bit] = new TrieNode();
            }
            cur = cur.children[bit];
        }
    }

    public int getMax(int num) {
        TrieNode cur = root;
        int maxi = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (cur.children[1 - bit] != null) {
                maxi = (maxi) | (1 << i);
                cur = cur.children[1 - bit];
            } else {
                cur = cur.children[bit];
            }
        }

        return maxi;
    }
}

public class MaximumXORWithanElementFromArray {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Trie trie = new Trie();
        ArrayList<ArrayList<Integer>> offlineQueries = new ArrayList<>();

        int q = queries.length;

        for (int i = 0; i < q; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(queries[i][1]);
            temp.add(queries[i][0]);
            temp.add(i);
            offlineQueries.add(temp);
        }

        offlineQueries.sort((a, b) -> Integer.compare(a.get(0), b.get(0)));

        Arrays.sort(nums);

        int ind = 0;
        int[] ans = new int[q];
        int n = nums.length;

        for (int i = 0; i < q; i++) {
            int xi = offlineQueries.get(i).get(1);
            int mi = offlineQueries.get(i).get(0);
            int qInd = offlineQueries.get(i).get(2);
            while (ind < n && nums[ind] <= mi) {
                trie.insert(nums[ind]);
                ind++;
            }
            if (ind != 0) {
                ans[qInd] = trie.getMax(xi);
            } else {
                ans[qInd] = -1;
            }

        }

        return ans;

    }
}
