package Trie;

import java.util.ArrayList;
import java.util.List;

public class Q212 {
    class Solution {
        //trie to prefix search
        class TrieNode{
            TrieNode[] children = new TrieNode[26];
            String word = null;
        }

        //define insert function
        public void insertWord(TrieNode root, String word){
            TrieNode cur = root;
            for(char c : word.toCharArray()){
                if(cur.children[c - 'a'] == null){//while?
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.word = word;
        }


        public List<String> findWords(char[][] board, String[] words) {
            TrieNode root = new TrieNode();
            //insert all the words
            for(String word : words){
                insertWord(root, word);//不需要用root 来调用吗？
            }

            List<String> result = new ArrayList();

            //backtracking
            int m = board.length, n = board[0].length;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(root.children[board[i][j] - 'a'] != null){
                        backtracking(board, root, result, i, j);
                    }
                }
            }

            return result;

        }

        //define backtracking
        public void backtracking(char[][] board, TrieNode root , List<String> result, int i, int j){
            //get the char and check if find the words
            char c = board[i][j];
            TrieNode cur = root.children[c - 'a'];

            if(cur.word != null){
                result.add(cur.word);
                cur.word = null;//avoid duplicate find
            }

            //mark the palce
            board[i][j] = '#';

            //four dirctions
            int[][] dirctions = {{1,0},{0,1},{-1,0},{0,-1}};

            //if not find the word keep finding
            for(int[] dirc : dirctions){
                int newI = i + dirc[0];
                int newJ = j + dirc[1];
                if(newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length){//满足条件检查 不是出口
                    if(board[newI][newJ] != '#' && cur.children[board[newI][newJ] - 'a'] != null){
                        backtracking(board, cur, result, newI, newJ);
                    }
                }

            }
            //recover
            board[i][j] = c;

            //check if the cur is the leafNode
            boolean isLeaf = true;
            for(TrieNode child : cur.children){
                if(child != null){
                    isLeaf = false;
                    break;
                }
            }

            if(isLeaf){
                root.children[c - 'a'] = null;
            }

        }
    }
}
