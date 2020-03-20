package study.algorithm.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by EricWang on 2020/3/20 11:21 AM.
 */
public class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(null);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        if (word == null || word.isEmpty()){
            return;
        }
        TrieNode fatherNode = root;
        for (int i = 0; i < word.length(); i ++){
            int currentChar = word.charAt(i);
            if (fatherNode.children.containsKey(currentChar)){
                fatherNode = fatherNode.children.get(currentChar);
                continue;
            }

            TrieNode currentNode = new TrieNode(currentChar);
            fatherNode.children.put(currentChar,currentNode);
            fatherNode = currentNode;
        }

        //mark last node as end
        fatherNode.isEnd = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        TrieNode lastMatchedNode = getLastMatchedNode(word);

        return lastMatchedNode!= null && lastMatchedNode.isEnd;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        TrieNode lastMatchedNode = getLastMatchedNode(prefix);

        return lastMatchedNode != null;
    }

    private TrieNode getLastMatchedNode(String word) {
        if (word == null || word.isEmpty()){
            return null;
        }
        TrieNode fatherNode = root;
        for (int i = 0; i < word.length(); i ++){
            int currentChar = word.charAt(i);
            if (fatherNode.children.containsKey(currentChar)){
                fatherNode = fatherNode.children.get(currentChar);
                continue;
            }
            return null;

        }

        return fatherNode;

    }

    class TrieNode{

        Integer val;

        Map<Integer,TrieNode> children;

        boolean isEnd;

        public TrieNode(Integer val) {
            this.val = val;
            children = new HashMap<>(16);
            isEnd = false;
        }
    }
}
