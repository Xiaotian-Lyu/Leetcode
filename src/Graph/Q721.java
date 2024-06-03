package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q721 {
    class Solution2 {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            //step1: hashmap<mail,index> -- use Unionfind.union the index
            Unionfind uf = new Unionfind(accounts.size());
            HashMap<String, Integer> mailIndexMap = new HashMap<>();

            //traversal the account
            for(int i = 0; i < accounts.size();i++){
                for(int j = 1; j < accounts.get(i).size(); j++){
                    //union the index
                    String mail = accounts.get(i).get(j);
                    //错误写法：//contansKey；contiansKey
                    if(mailIndexMap.containsKey(mail)){
                        uf.Union(i,mailIndexMap.get(mail));
                    }else{
                        mailIndexMap.put(mail,i);
                    }
                }
            }

            //step2: hashmap<index,mial> -- use Unionfind.find the root node index
            HashMap<Integer, List<String>> indexMailMap = new HashMap<>();
            //traversal all the mail //错误写法keyset
            for(String mail : mailIndexMap.keySet()){
                int index = mailIndexMap.get(mail);
                //下面这一步不能写成int rootIndex = uf.parents[index];有例外情况
                /**
                 * [["Hanzo","Hanzo2@m.co","Hanzo3@m.co"],
                 * ["Hanzo","Hanzo4@m.co","Hanzo5@m.co"],
                 * ["Hanzo","Hanzo0@m.co","Hanzo1@m.co"],
                 * ["Hanzo","Hanzo3@m.co","Hanzo4@m.co"],
                 * ["Hanzo","Hanzo7@m.co","Hanzo8@m.co"],
                 * ["Hanzo","Hanzo1@m.co","Hanzo2@m.co"],
                 * ["Hanzo","Hanzo6@m.co","Hanzo7@m.co"],
                 * ["Hanzo","Hanzo5@m.co","Hanzo6@m.co"]]
                 */
                int rootIndex = uf.find(index);
                indexMailMap.putIfAbsent(rootIndex, new ArrayList<>());
                indexMailMap.get(rootIndex).add(mail);
            }

            //step3: print res
            List<List<String>> res = new ArrayList<>();
            //traversal the map get the list of mail
            for(int i : indexMailMap.keySet()){
                List<String> listOfMail = indexMailMap.get(i);
                String name = accounts.get(i).get(0);
                listOfMail.sort((a,b) -> a.compareTo(b));
                listOfMail.add(0,name);
                res.add(listOfMail);
            }
            return res;
        }

        class Unionfind{
            int[] parents;
            //n
            public Unionfind(int n){
                this.parents = new int[n];
                for(int i = 0; i < n ; i++){
                    parents[i] = i;
                }
            }

            //union the index
            public void Union(int i,int j){
                //错误写法：int p = parents[i],q = parents[j];
                int p = find(i),q = find(j);
                if(p == q){
                    return;
                }
                parents[p]= q;
            }

            //find the root node index
            public Integer find(int i){
                while(parents[i] != i ){
                    parents[i] = parents[parents[i]];
                    i = parents[i];
                }
                return i;
            }
        }

    }
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
                    parents[i] = parents[parents[i]];//只是效率上的优化 逻辑可以不用
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
