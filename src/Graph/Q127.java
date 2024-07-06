package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q127 {
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            //use hashset to check if the word in the wordlist
            HashSet<String> hashSet = new HashSet<>();
            for(String word : wordList){
                hashSet.add(word);
            }

            //简化写法：Set<String> wordSet = new HashSet<>(wordList);

            //put the beginWord into queue
            Queue<String> queue = new LinkedList<>();
            queue.add(beginWord);

            if(!hashSet.contains(endWord)){
                return 0;
            }

            //check if the hashSet contanis endWord 废话肯定存在啊！！！！
            int level = 1;
            // if(hashSet.contains(endWord)){//错误：hashSet.contiansKey
            //     return level;
            // }

            //keep poll out the word from queue - change one letter
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    String wordInQueue = queue.poll();

                    //change one letter
                    //1.transfer string to array
                    char[] oldWord = wordInQueue.toCharArray();//注意这里是char

                    //2.traversal each letter -->try 26 letters
                    for(int j = 0; j < oldWord.length; j++){
                        char original = oldWord[j];//keep the original char

                        for(char change = 'a'; change <= 'z'; change++){
                            if (change == original) continue;//skip the duplicate char 可以加可以不加

                            oldWord[j] = change;
                            String newWord = new String(oldWord);//transfer back after change one letter

                            //3.check the new word if the endword
                            if(newWord.equals(endWord)){
                                return level + 1;
                            }

                            //4.check the new word if in the hashset - put the newword into queue
                            //remove from hashset
                            if(hashSet.contains(newWord)){
                                queue.add(newWord);
                                hashSet.remove(newWord);
                            }
                        }
                        //change back 别忘记
                        oldWord[j] = original;

                    }
                }

                //5.after poll all the word in the queue in one level ,level++
                level++;

            }

            //return the result 到这一步就是没有找到了
            return 0;
        }
    }
}
