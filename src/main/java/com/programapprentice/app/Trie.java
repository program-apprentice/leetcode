package com.programapprentice.app;

import java.util.HashMap;
import java.util.Map;

/**
 * User: program-apprentice
 * Date: 10/4/15
 * Time: 11:37 AM
 */
class TrieNode {
    public Integer value;
    public String key;
    public Map<String, TrieNode> childrenMap;
    // Initialize your data structure here.
    public TrieNode() {
        this(null);
    }

    public TrieNode(String key) {
        this.key = key;
        this.value = null;
        this.childrenMap = new HashMap<String, TrieNode>();
    }
}

public class Trie {
    private TrieNode root;
    private int nextValue;

    public Trie() {
        root = new TrieNode();
        this.nextValue = 1;
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = this.root;
        for(int i =0; i < word.length(); i++) {
            String cur = word.substring(i, i+1);
            TrieNode child = node.childrenMap.get(cur);
            if(child == null) {
                if(i == word.length()-1) {
                    child = new TrieNode(word);
                    child.value = this.nextValue;
                    this.nextValue++;
                } else {
                    child = new TrieNode(cur);
                }
                node.childrenMap.put(cur, child);
            } else {
                if(i == word.length()-1) {
                    if(child.value == null) {
                        child.value = this.nextValue;
                        this.nextValue++;
                    }
                } else {
                    if(child.value != null) {
                        child.key = cur;
                    }
                }
            }
            node = child;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = this.root;
        for(int i = 0; i < word.length(); i++) {
            String cur = word.substring(i, i+1);
            TrieNode child = node.childrenMap.get(cur);
            if(child == null) {
                return false;
            }
            if(i == word.length()-1) {
                if(child.value == null) {
                    return false;
                }
                break;
            }
            node = child;
        }
        return true;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = this.root;
        for(int i = 0; i < prefix.length(); i++) {
            String cur = prefix.substring(i, i+1);
            TrieNode child = node.childrenMap.get(cur);
            if(child == null) {
                return false;
            }
            node = child;
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");