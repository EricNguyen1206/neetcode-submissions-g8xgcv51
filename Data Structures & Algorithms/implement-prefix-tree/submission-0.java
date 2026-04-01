class TrieNode {
    TrieNode[] childs = new TrieNode[26];
    boolean endOfWord = false;
}

class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.childs[i] == null) {
                cur.childs[i] = new TrieNode();
            }
            cur = cur.childs[i];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.childs[i] == null) return false;
            cur = cur.childs[i];
        }

        return cur.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            int i = c - 'a';
            if (cur.childs[i] == null) return false;
            cur = cur.childs[i];
        }
        return true;
    }
}
