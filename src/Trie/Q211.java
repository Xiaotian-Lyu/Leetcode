package Trie;

public class Q211 {
    class WordDictionary2 {
        //data fields
        class Node{
            Node[] children = new Node[26];
            boolean isWord = false;
            //default constructor
        }
        Node root = new Node();

        //default constructor
        public void addWord(String word){
            Node cur = root;
            for(char c : word.toCharArray()){
                if(cur.children[c - 'a'] == null) cur.children[c - 'a'] = new Node();
                cur = cur.children[c - 'a'];//?
            }
            cur.isWord = true;
        }

        public boolean search(String word){
            Node cur = root;
            return helper(word, cur, 0);
        }

        //recursion
        //index - index of the word
        private boolean helper(String word, Node cur, int index){
            //exit of the recursion
            if(index == word.length()) return cur.isWord;

            char c = word.charAt(index);
            if( c != '.'){
                if(cur.children[c - 'a'] == null) return false;
                return helper(word, cur.children[c - 'a'], index + 1);
            }

            //start with '.'
            for(Node child : cur.children){
                if(child != null){
                    if(helper(word, child, index + 1)) return true;
                }
            }
            return false;
        }


    }
    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */
    class WordDictionary {
        //data fields
        class Node{
            Node[] children = new Node[26];
            boolean isWord = false;
            //default constructor
        }
        Node root = new Node();

        //default constructor
        public void addWord(String word){
            Node cur = root;
            for(char c : word.toCharArray()){
                if(cur.children[c - 'a'] == null) cur.children[c - 'a'] = new Node();
                cur = cur.children[c - 'a'];//?
            }
            cur.isWord = true;
        }

        public boolean search(String word){
            Node cur = root;
            return helper(word, cur, 0);
        }

        //recursion
        private boolean helper(String word, Node cur, int index){
            //exit of the recursion
            if( index == word.length()) return cur.isWord;

            //get the first char of the word
            //错误写法：char c = word[index];
            //no'.' or end with '.'
            char c = word.charAt(index);
            if( c != '.'){
                if(cur.children[c - 'a'] == null) return false;
                return helper(word, cur.children[c - 'a'], index + 1);
            }

            //start with '.'
            for(Node child : cur.children){
                if(child != null) {
                    //use helper
                    if(helper(word, child, index + 1)) return true;
                }

            }
            return false;
        }


    }
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
