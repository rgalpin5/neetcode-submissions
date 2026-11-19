class TrieNode {
    char val;
    HashMap<Character, TrieNode> nodes;
    boolean word;
    public TrieNode(char c) {
        word = false;
        val = c;
        nodes = new HashMap<>();
    }
    
    public boolean hasNode(char c) {
        return this.nodes.containsKey(c);
    }

    public TrieNode getNode(char c) {
        if(this.nodes.containsKey(c)) {
            return this.nodes.get(c);
        }
        return null;
    }

    public void insertNode(char c) {
        this.nodes.put(c, new TrieNode(c));
    }

    public void isWord() {
        this.word = true;
    }

    public boolean isNodeWord() {
        return this.word;
    }
}

class PrefixTree {
    TrieNode root;
    public PrefixTree() {
        root = new TrieNode('0');
    }

    public void insert(String word) {
        TrieNode runner = root;
        for(int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if(runner.hasNode(currChar)) {
                runner = runner.getNode(currChar);
            }
            else {
                runner.insertNode(currChar);
                runner = runner.getNode(currChar);
            }
        }
        runner.isWord();
    }

    public boolean search(String word) {
        TrieNode runner = root;
        for(int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if(runner.hasNode(currChar)) {
                runner = runner.getNode(currChar);
            }
            else {
                return false;
            }
        }
        return runner.word;
    }

    public boolean startsWith(String prefix) {
        TrieNode runner = root;
        for(int i = 0; i < prefix.length(); i++) {
            char currChar = prefix.charAt(i);
            if(runner.hasNode(currChar)) {
                runner = runner.getNode(currChar);
            }
            else {
                return false;
            }
        }
        return true;
    }
}

