package Trie;

public class Q208 {
    class Trie {
        class Node{
            Node[] children = new Node[26];//26 characters
            boolean isWord = false;
        }
        Node root = new Node();//每新建一个Tire 它就有一个root属性

        public Trie(){

        }

        public void insert(String word){
            Node cur = root;//需要保留root 的位置
            for(char c : word.toCharArray()){
                if(cur.children[c - 'a'] == null) cur.children[c - 'a'] = new Node();
                //在相应index上存一个node 说明这个位置的字母存在
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }

        public boolean search(String word){
            Node cur = root; //需要保留root 的位置
            for(char c : word.toCharArray()){
                if(cur.children[c - 'a'] == null) return false;
                //在相应index上存一个node 说明这个位置的字母存在
                cur = cur.children[c - 'a'];
            }
            //check 一下是否存了app 而不是 apple
            return cur.isWord;
        }

        public boolean startsWith(String pre){
            Node cur = root;//需要保留root 的位置
            for(char c : pre.toCharArray()){
                if(cur.children[c - 'a'] == null)  return false;
                //在相应index上存一个node 说明这个位置的字母存在
                cur = cur.children[c - 'a'];
            }
            //after traversal we all find the pre
            return true;
        }


    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
