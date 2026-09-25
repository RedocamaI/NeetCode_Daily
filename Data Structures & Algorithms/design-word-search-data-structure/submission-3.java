class TrieNode {
    Character val;
    Map<Character, TrieNode> children;
    boolean isEnd;

    TrieNode(Character val, Map<Character, TrieNode> children, boolean isEnd) {
        this.val = val;
        this.children = children;
        this.isEnd = isEnd;
    }

    void setChildren(Map<Character, TrieNode> children) {
        this.children = children;
    }
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode('0', new HashMap<>(), false);
    }

    public void addWord(String word) {
        TrieNode node = this.root;
        int n = word.length();
        Map<Character, TrieNode> children;

        for(int i=0;i<n;i++) {
            char ch = word.charAt(i);
            children = node.children;
            if(children.containsKey(ch)) {
                node = children.get(ch);
                continue;
            }

            if(i == n-1) {
                children.put(ch, new TrieNode(ch, new HashMap<>(), true));
                node.setChildren(children);
                continue;
            }

            children.put(ch, new TrieNode(ch, new HashMap<>(), false));
            node.setChildren(children);
            node = children.get(ch);
        }
    }

    private boolean startSearching(int ind, String word, TrieNode node) {
        int n = word.length();

        for(int i=ind;i<n;i++) {
            Map<Character, TrieNode> children = node.children;
            char ch = word.charAt(i);
            if(ch == '.') {
                if(children.isEmpty())
                    return false;
                
                for(Map.Entry<Character, TrieNode> entry : children.entrySet()) {
                    if(i == n-1) {
                        if(entry.getValue().isEnd)
                            return true;
                        
                        continue;
                    }

                    if(startSearching(i+1, word, entry.getValue()))
                        return true;
                }

                return false;
            }else {
                if(!children.containsKey(ch))
                    return false;
                
                node = children.get(ch);
            }
        }

        return node.isEnd;
    }

    public boolean search(String word) {
        int n = word.length();
        TrieNode node = this.root;

        return startSearching(0, word, node);
    }
}
