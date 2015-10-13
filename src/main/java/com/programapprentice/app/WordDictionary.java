package com.programapprentice.app;

import java.util.*;

/**
 * User: program-apprentice
 * Date: 10/11/15
 * Time: 10:31 PM
 */
public class WordDictionary {
    private final int R = 26;
    class TrieNode {
        public char c;
        public boolean endOfWord = false;
        public TrieNode[] next = null;
        public TrieNode(char c) {
            next = new TrieNode[R];
            endOfWord = false;
            this.c = c;
        }
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode(' ');
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = this.root;
        TrieNode child = null;
        for(int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            child = node.next[cur-'a'];
            if(child == null) {
                child = new TrieNode(cur);
                node.next[cur-'a'] = child;
            }
            if(i == word.length()-1) {
                child.endOfWord = true;
            }
            node = child;
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        Queue<TrieNode> queue = new LinkedList<TrieNode>();
        Queue<Integer> depthQueue = new LinkedList<Integer>();
        queue.add(root);
        depthQueue.add(0);
        while(!queue.isEmpty()) {
            int depth = depthQueue.remove();
            if(depth == word.length()) {
                break;
            }
            TrieNode node = queue.remove();
            char cur = word.charAt(depth);
            if(depth == word.length()-1) {
                if(cur == '.') {
                    for(TrieNode child : node.next) {
                        if(child != null && child.endOfWord) {
                            return true;
                        }
                    }
//                    return false; // this one should be removed.
                } else {
                    if(node.next[cur-'a'] != null && node.next[cur-'a'].endOfWord) {
                        return true;
                    }
                }
            } else {
                if(cur == '.') {
                    for(TrieNode child : node.next) {
                        if(child != null) {
                            queue.add(child);
                            depthQueue.add(depth + 1);
                        }
                    }
                } else {
                    if(node.next[cur-'a'] != null) { // wrong: if(node.c ==  cur && node.next[cur-'a'] != null) {
                        queue.add(node.next[cur - 'a']);
                        depthQueue.add(depth + 1);
                    }
                }
            }
        }
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");