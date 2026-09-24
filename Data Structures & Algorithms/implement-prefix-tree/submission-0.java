class TrieNode {
    Character letter;
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    TrieNode(Character letter, 
    Map<Character, TrieNode> children, boolean isEnd) {
        this.letter = letter;
        this.children = children;
        this.isEndOfWord = isEnd;
    }

    void setChildren(Map<Character, TrieNode> children) {
        this.children = children;
    }

    void setIsEnd(boolean isEndOfWord) {
        this.isEndOfWord = isEndOfWord;
    }
}

class PrefixTree {
    TrieNode root;

    public PrefixTree() {
        this.root = new TrieNode('0', new HashMap<>(), false);     
    }

    public void insert(String word) {
        TrieNode node = this.root;

        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            Map<Character, TrieNode> children = node.children;
            if(children.containsKey(ch)) {
                node = children.get(ch);
                if(i == word.length()-1) {
                    node.setIsEnd(true);
                }
                
                continue;
            }

            children.put(ch, new TrieNode(ch, new HashMap<>(), false));
            if(i == word.length()-1){
                children.put(ch, new TrieNode(ch, new HashMap<>(), true));
            }
            node.setChildren(children);

            node = children.get(ch);
        }
    }

    public boolean search(String word) {
        TrieNode node = this.root;
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            Map<Character, TrieNode> children = node.children;
            if(!children.containsKey(ch))
                return false;
            
            node = children.get(ch);

            if(i == word.length()-1) {
                if(!node.isEndOfWord)
                    return false;
            }
        }

        return true;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = this.root;
        for(int i=0;i<prefix.length();i++) {
            char ch = prefix.charAt(i);
            Map<Character, TrieNode> children = node.children;
            if(!children.containsKey(ch)) {
                return false;
            }

            node = children.get(ch);
        }

        return true;
    }
}
