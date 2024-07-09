package Trie;

public class Q211 {
    class WordDictionary3 {
        Node root = new Node();

        class Node{
            //attributes 错误写法
            Node[] children = new Node[26];
            boolean isWord = false;
            //defalut constructor
        }
        public WordDictionary3() {
            //defalut constructor
        }

        public void addWord(String word) {
            Node cur = root;
            for(char c : word.toCharArray()){
                if(cur.children[c - 'a'] == null) cur.children[c - 'a'] = new Node();
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }

        public boolean search(String word) {
            //create a function to do the recursion
            Node cur = root;//在 search 方法中，cur 应该初始化为 root，而不是一个新的 Node 对象。
            return helper(word, 0, cur);
        }

        public boolean helper(String word, int index ,Node cur){
            //exit of the recursion
            if(index == word.length()) return cur.isWord;

            char c = word.charAt(index);

            //if not '.'
            if(c != '.'){
                if(cur.children[c - 'a'] == null) return false;
                //find the char //错 if(helper(word, index + 1, cur.children[c - 'a'])) return true;
                return helper(word, index + 1, cur.children[c - 'a']);//直接return 调用helper 让下一层来返回值就行
            }


            //if is the '.'
            for(Node children : cur.children){
                if(children != null){
                    if(helper(word, index + 1, children)) return true;//这里要判断下一层是true 才能返回 true 因为‘.'可以是任何位置
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
