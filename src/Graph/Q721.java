package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q721 {
    class Solution {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            UnionFind uf = new UnionFind(accounts.size());
            Map<String,Integer> mailIndexmap = new HashMap<>();
            for(int i = 0; i < accounts.size();i++){
                for(int j = 1; j < accounts.get(i).size(); j++){
                    String mail = accounts.get(i).get(j);
                    //contansKey
                    if(mailIndexmap.containsKey(mail)){
                        uf.Union(i,mailIndexmap.get(mail));
                    }else{
                        mailIndexmap.put(mail,i);
                    }
                }
            }
            //错误写法：Map<Integer,String> indexMailmap = new HashMap<>();
            Map<Integer,List<String>> indexMailmap = new HashMap<>();
            for(String mail : mailIndexmap.keySet()){
                //通过邮箱 找相同root node
                int index = uf.find(mailIndexmap.get(mail));
                indexMailmap.putIfAbsent(index, new ArrayList<>());
                indexMailmap.get(index).add(mail);
            }

            List<List<String>> res = new ArrayList<>();
            for(Integer i : indexMailmap.keySet()){
                List<String> listOfMail = indexMailmap.get(i);
                //合并的是相同邮箱 相同名字的情况
                String name = accounts.get(i).get(0);
                listOfMail.sort((a, b) -> a.compareTo(b));
                listOfMail.add(0,name);
                res.add(listOfMail);
            }
            return res;



        }

        class UnionFind{
            int[] parents;

            public UnionFind(int n){
                this.parents = new int[n];
                for(int i = 0 ; i< n ; i++){
                    parents[i] = i;
                }
            }

            public int find(int i){
                while(parents[i] != i){
                    parents[i] = parents[parents[i]];
                    i = parents[i];
                }
                return i;
            }

            public void Union(int i , int j){
                //错误写法：if(parents[i] == parents[j])
                int p = find(i), q = find(j);
                // if(p == q){
                //     //p = parents[q];
                //     p = parents[q];
                // }
                if(p == q) return;
                //p = parents[q];
                parents[q] = p;
            }
        }

    }
}
