class TrieNode {
    TrieNode[] children;
    boolean isWord;

    TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode runner = root;
        for(int i = 0; i < word.length(); i++) {
            if(runner.children[word.charAt(i) - 'a'] == null) {
                runner.children[word.charAt(i) - 'a'] = new TrieNode();
            }          
            runner = runner.children[word.charAt(i) - 'a'];
        }
        runner.isWord = true;
    }

    public boolean search(String word) {
        return dfs(root, 0, word);
    }

    private boolean dfs(TrieNode node, int i, String word) {
        if(i == word.length()) return node.isWord;
        else if(word.charAt(i) == '.') {
            for(int idx = 0; idx < 26; idx++) {
                if(node.children[idx] != null) {
                    if(dfs(node.children[idx], i + 1, word)) return true;
                }
            }
            return false;
        }
        else if(node.children[word.charAt(i) - 'a'] == null) return false;
        else return dfs(node.children[word.charAt(i) - 'a'], i + 1, word);
    }
}
