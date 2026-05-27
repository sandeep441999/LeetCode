package trie;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

public class DesignAddandSearchWordsDataStructure {
    TrieNode root;

    public DesignAddandSearchWordsDataStructure() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        return dfs(word, 0, curr);
    }

    public boolean dfs(String word, int idx, TrieNode node) {
        if (node == null)
            return false;

        if (idx == word.length())
            return node.isEnd;

        char c = word.charAt(idx);

        if (c == '.') {
            for (TrieNode child : node.children) {
                if (child != null && dfs(word, idx + 1, child))
                    return true;
            }
            return false;
        }
        int childIdx = c - 'a';
        return dfs(word, idx + 1, node.children[childIdx]);
    }
}
