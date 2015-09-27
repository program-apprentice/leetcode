package com.programapprentice.app;

import java.util.*;

/**
 * User: program-apprentice
 * Date: 9/9/15
 * Time: 5:54 PM
 */
public class WordLadder_127 {
    public List<String> distanceOne(String input) {
        List<String> output = new ArrayList<String>();
        char[] chars = input.toCharArray();
        for(int i = 0; i < input.length(); i++) {
            char curChar = chars[i];
            for(char t = 'a'; t <= 'z'; t++) {
                if(curChar != t) {
                    output.add(new String(chars));
                }
            }
            chars[i] = curChar;
        }
        return output;
    }

    public List<String> filterByDict(Set<String> wordList, List<String> words) {
        List<String> output = new ArrayList<String>();
        for(String word : words) {
            if(wordList.contains(word)) {
                output.add(word);
            }
        }
        return output;
    }



    class Node {
        String word;
        int depth;
        HashSet<String> record;
        public Node(String word, int depth, HashSet<String> record) {
            this.word = word;
            this.depth = depth;
            this.record = record;
        }
    }
    // still to slow
    public int ladderLength_v3(String start, String end, Set<String> dict) {
        Queue<Node> queue = new LinkedList<Node>();
        HashSet<String> record = new HashSet<String>();
        record.add(start);
        queue.add(new Node(start, 1, record));
        while(!queue.isEmpty()) {
            Node cur = queue.remove();
            String word = cur.word;
            int depth = cur.depth;
            record = cur.record;
            char[] charArray = word.toCharArray();
            for(int i = 0; i < word.length(); i++) {
                for(char c = 'a'; c <= 'z'; c++) {
                    charArray[i] = c;
                    String newWord = new String(charArray);
                    if(newWord.equals(end)) {
                        return depth + 1;
                    }
                    if(newWord.equals(word)) {
                        continue;
                    }
                    if(dict.contains(newWord) && !record.contains(newWord)) {
                        HashSet<String> newRecord = new HashSet<String>();
                        newRecord.addAll(record);
                        newRecord.add(newWord);
                        queue.add(new Node(newWord, depth+1, newRecord));
                    }
                }
            }
        }
        return 0;
    }

    public int ladderLength(String start, String end, Set<String> dict) {
        Set<String> visited = new HashSet<String>();
        visited.add(start); // missing this one
        Queue<String> wordQueue = new LinkedList<String>();
        Queue<Integer> depthQueue = new LinkedList<Integer>();
        wordQueue.add(start);
        depthQueue.add(1);
        String curWord = null;
        int depth = 0;
        while(!wordQueue.isEmpty()) {
            curWord = wordQueue.remove();
            depth = depthQueue.remove();
            // This one is in wrong positon char[] charArray = curWord.toCharArray();
            for(int i = 0; i < curWord.length(); i++) {
                char[] charArray = curWord.toCharArray();
                for(char c = 'a'; c <= 'z'; c++) {
                    charArray[i] = c;
                    String newWord = new String(charArray);
                    if(newWord.equals(end)) { // wrong: if(newWord.equals(end)) {
                        return depth+1; // return depth++;
                    }
                    if(newWord.equals(curWord)) {
                        continue;
                    }
                    if(dict.contains(newWord) && !visited.contains(newWord)) {
                        wordQueue.add(newWord);
                        depthQueue.add(depth+1); // wrong: depthQueue.add(depth++);
                        visited.add(newWord);
                    }
                }
            }
        }
        return 0;
    }
}
