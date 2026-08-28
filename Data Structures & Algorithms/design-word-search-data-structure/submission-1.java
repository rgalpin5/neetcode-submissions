class TrieNode {
    boolean word;
    HashMap<Character, TrieNode> children;

    public TrieNode(){
        word = false;
        children = new HashMap<>();
    }
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(!curr.children.containsKey(c)){
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.word = true;
    }

    public boolean search(String word) {
        return searchInNode(word, 0, root);
    }

    private boolean searchInNode(String word, int index, TrieNode node) {
        if(index == word.length()) return node.word;

        char ch = word.charAt(index);

        if(ch == '.'){
            for(TrieNode child : node.children.values()){
                if (searchInNode(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        }
        else{
            TrieNode child = node.children.get(ch);
            if(child == null) return false;

            return searchInNode(word, index+1, child);
        }
    }
}
