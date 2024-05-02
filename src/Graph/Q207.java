package Graph;

import java.util.*;

public class Q207 {
    class Solution2 {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            // 创建邻接表，用 Map 表示，值为 Set
            Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();
            for (int i = 0; i < numCourses; i++) {
                adjacencyList.put(i, new HashSet<>());
            }

            // 统计每门课程的入度
            int[] indegree = new int[numCourses];

            // 构建邻接表和入度数组
            for (int[] prerequisite : prerequisites) {
                int course = prerequisite[0];
                int prerequisiteCourse = prerequisite[1];
                adjacencyList.get(prerequisiteCourse).add(course);
                indegree[course]++;
            }

            // 将入度为0的课程加入队列作为起始点
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }

            // 记录已学习的课程数量
            int learnedCourses = 0;
            while (!queue.isEmpty()) {
                int course = queue.poll();
                learnedCourses++;
                // 将当前课程的后继课程的入度减一，若入度为0，则加入队列
                for (int nextCourse : adjacencyList.get(course)) {
                    indegree[nextCourse]--;
                    if (indegree[nextCourse] == 0) {
                        queue.offer(nextCourse);
                    }
                }
            }

            // 若所有课程都能学习，则返回true；否则返回false
            return learnedCourses == numCourses;
        }
    }

    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {

            //ArrayList  store the adjstList. 错误写法new ArrayList();
            List<List<Integer>> adjstlist = new ArrayList<>();

            //int[] store the nums of precoures
            int[] preCourseCount = new int[numCourses];


            //put all the data
            //why?
            for(int i = 0; i < numCourses; i++){
                adjstlist.add(new ArrayList<>());
            }

            //错误写法  for(int i = 0; i < prerequisites.length; i++)
            for(int[] edge : prerequisites){
                int course = edge[0];
                int preCourse = edge[1];
                adjstlist.get(preCourse).add(course);
                preCourseCount[course]++;
            }

            //queue store the precourse = 0.
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < numCourses; i++){
                if(preCourseCount[i] == 0){
                    queue.offer(i);
                }
            }

            //visited
            int visited = 0;
            while(!queue.isEmpty()){
                int canTakeCourse = queue.poll();
                visited++;

                //if the queue poll is other's precourse
                for(int nextCourse : adjstlist.get(canTakeCourse)){
                    //错误写法preCourseCount[canTakeCourse]--;
                    //if(preCourseCount[canTakeCourse] == 0){
                    preCourseCount[nextCourse]--;
                    if(preCourseCount[nextCourse] == 0){
                        queue.offer(nextCourse);
                    }
                }
            }
            //compare visited == numsCourse ?
            return visited == numCourses;

        }

    }
}
