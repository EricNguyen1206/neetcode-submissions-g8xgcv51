class TrieNode {
    TrieNode[] childrend = new TrieNode[26];
    boolean endOfWord = false;
}


class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.childrend[i] == null) {
                cur.childrend[i] = new TrieNode();
            }
            cur = cur.childrend[i];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        return _dfs_search(word, root, 0);
    }

    private boolean _dfs_search(String word, TrieNode node, int index) {
        if (index == word.length()) {
            return node.endOfWord;
        }
        char c = word.charAt(index);
        if (c == '.') {
            // try all the potential node
            for (TrieNode n : node.childrend) {
                if (n != null && _dfs_search(word, n, index+1)) {
                    return true;
                }
            }
            return false;
        }
        int i = c - 'a';
        if (node.childrend[i] != null) {
            return _dfs_search(word, node.childrend[i], index+1);
        }
        return false;
    }
}
