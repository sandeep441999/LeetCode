package trie;

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
        int maxNum = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (cur.children[1 - bit] != null) {
                maxNum = maxNum | (1 << i);
                cur = cur.children[1 - bit];
            } else {
                cur = cur.children[bit];
            }
        }

        return maxNum;
    }
}

public class MaximumXORofTwoNumbersinanArray {
    public int findMaximumXOR(int[] nums) {
        // int maxi = 0;
        // for(int i=0; i<nums.length-1; i++) {
        // for(int j=i+1; j<nums.length; j++) {
        // maxi = Math.max(maxi, nums[i]^nums[j]);
        // }
        // }

        // return maxi;

        int maxi = 0;
        Trie trie = new Trie();
        for (int i = 0; i < nums.length; i++) {
            trie.insert(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            maxi = Math.max(maxi, trie.getMax(nums[i]));
        }

        return maxi;
    }
}
