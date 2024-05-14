package Graph;

import java.util.*;

public class Q210 {
    class SolutionSelf {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            //adjacencyMap - course precourse
            //错误写法：Map<Integer,set<Integer>>
            Map<Integer,Set<Integer>> adjacencyMap = new HashMap<>();

            //indegree - each course's precourses number
            int[] indegree = new int[numCourses];

            //put all data into the map
            for(int[] prerequisite : prerequisites){
                int course = prerequisite[0];
                int preCourse = prerequisite[1];
                adjacencyMap.putIfAbsent(preCourse,new HashSet<>());//错：putIfAbscent
                adjacencyMap.get(preCourse).add(course);
                indegree[course]++;
            }

            //queue - store : canTakeCourse    indegree[course] == 0
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < indegree.length; i++){
                if(indegree[i] == 0){
                    //错误写法：queue.add(indegree[i]);
                    queue.add(i);
                }
            }

            //poll the canTakeCourse - finishedCourse
            //result
            int finishedCourse = 0;
            int[] res = new int[numCourses];
            while(!queue.isEmpty()){
                int canTakeCourse = queue.poll();
                //错误写法：res.add(canTakeCourse);???
                res[finishedCourse++] = canTakeCourse;

                if(adjacencyMap.containsKey(canTakeCourse)){//containskey

                    for(int nextCourse : adjacencyMap.get(canTakeCourse)){
                        indegree[nextCourse]--;//重要
                        if(indegree[nextCourse] == 0){
                            queue.add(nextCourse);
                        }
                    }
                }

            }

            //check with the numCourses = finishedCourse?
            //return the result
            //错误写法：return numCourses == finishedCourse ? res : new int[];
            return numCourses == finishedCourse ? res : new int[0];
        }
    }
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            Map<Integer, Set<Integer>> adjacencyMap = new HashMap<>();
            int[] indegree = new int[numCourses];
            for (int[] prerequisite : prerequisites) {
                int course = prerequisite[0], preCourse = prerequisite[1];
                adjacencyMap.putIfAbsent(preCourse, new HashSet<>());
                adjacencyMap.get(preCourse).add(course);
                indegree[course]++;
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < indegree.length; i++) {
                //add 方法在容量受限的队列中可能会抛出 IllegalStateException，
                //而 offer 方法则会返回 false。
                if (indegree[i] == 0) queue.add(i);
            }
            int finishedCourse = 0;
            int[] res = new int[numCourses];
            while (!queue.isEmpty()) {
                Integer canTakeCourse = queue.poll();
                res[finishedCourse++] = canTakeCourse;
                if (adjacencyMap.containsKey(canTakeCourse)) {
                    /**
                     没有这个检查会导致尝试获取 adjacencyMap.get(3) 的结果为 null，
                     然后在 for 循环中迭代 null 会抛出 NullPointerException
                     leetcode 207里面没有判断是因为初始化 都有key没有next course的 为空的set

                     Map<Integer,Set<Integer>> adjacencyMap = new HashMap<>();
                     for(int i = 0; i < numCourses; i++){
                     adjacencyMap.put(i,new HashSet<>());
                     }
                     */


                    for (Integer nextCourse : adjacencyMap.get(canTakeCourse)) {
                        indegree[nextCourse]--;
                        if (indegree[nextCourse] == 0) {
                            queue.add(nextCourse);
                        }
                    }
                }
            }
            return finishedCourse == numCourses ? res : new int[0];
        }
    }
}
