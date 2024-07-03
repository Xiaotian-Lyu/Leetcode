package Graph;

public class Q323 {
    class Solution2 {
        public int countComponents(int n, int[][] edges) {
            UnionFind unionFind = new UnionFind(n);
            for(int[] edge : edges){
                unionFind.union(edge[0],edge[1]);
            }
            return unionFind.components;
        }

        class UnionFind{
            int components;
            int[] parents;

            //constructer
            public UnionFind(int n){
                this.components = n;
                this.parents = new int[n];//错误this.parents = int[n];
                //initialize
                for(int i = 0; i < n ; i++){
                    parents[i] = i;
                }
            }

            //union
            //union方法有一个问题。为了正确执行联合操作，你需要将一个节点的根指向另一个节点的根，而不是直接将节点i的父节点设为j的父节点。
            public void union(int i, int j){
                //check the parents
                if(find(i) == find(j)) return;
                //union //错误写法：parents[i] = find(j);
                // 错误写法 iParent = jParent; iParent = parents[jParent]
                /**
                 iParent = jParent 只是将局部变量 iParent 设置为 jParent，这不会改变 parents 数组的内容。实际的父节点关系并没有更新到 parents 数组中。
                 iParent = parents[jParent] 同样只是更新局部变量 iParent，而没有改变 parents 数组中的内容。
                 */
                parents[find(i)] = find(j);
                components--;
            }

            //find - return the parents of i
            public int find(int i){
                //另一种写法：
                /**
                 while (parents[i] != i) {
                 parents[i] = parents[parents[i]]; // 路径压缩
                 i = parents[i];
                 }
                 return i;
                 */
                if(parents[i] != i){
                    parents[i] = find(parents[i]);
                }
                return parents[i];
            }

        }
    }
    class Solution {
        public int countComponents(int n, int[][] edges) {
            UnionFind unionFind = new UnionFind(n);
            for(int[] edge : edges){
                unionFind.union(edge[0],edge[1]);
            }
            return unionFind.components;
        }

        class UnionFind{
            int components;
            int[] parents;

            //constructer
            public UnionFind(int n){
                this.components = n;
                this.parents = new int[n];//错误this.parents = int[n];
                //initialize
                for(int i = 0; i < n ; i++){
                    parents[i] = i;
                }
            }

            //union
            //union方法有一个问题。为了正确执行联合操作，你需要将一个节点的根指向另一个节点的根，而不是直接将节点i的父节点设为j的父节点。
            public void union(int i, int j){
                //check the parents
                if(find(i) == find(j)) return;
                //union //错误写法：parents[i] = find(j);
                parents[find(i)] = find(j);
                components--;
            }

            //find - return the parents of i
            public int find(int i){
                //错误：while(parents[i] != i){
                if(parents[i] != i){
                    //错误：parents[i] = find(i);
                    parents[i] = find(parents[i]);
                }
                return parents[i];
            }

        }
    }
}
