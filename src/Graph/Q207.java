package Graph;

import java.util.*;

public class Q207 {
    class Solution2 {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            //create the adjacency map
            Map<Integer,Set<Integer>> adjacencyMap = new HashMap<>();
            for(int i = 0; i< numCourses; i++){
                adjacencyMap.put(i, new HashSet<>());//Map 放的key 是preCourse
            }

            //Count the Indegree of each class
            int[] indegree = new int[numCourses];

            //put the data into the map and array
            for(int[] prerequisite:prerequisites){
                int course = prerequisite[0];
                int preCourse = prerequisite[1];
                adjacencyMap.get(preCourse).add(course);
                indegree[course]++;
            }

            //put the indegree = 0 into a queue
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < numCourses; i++){
                if(indegree[i] == 0){
                    queue.offer(i);
                }
            }

            //count all the course number
            int learnedcourse = 0;
            while(!queue.isEmpty()){
                int course = queue.poll();
                learnedcourse++;

                for(int nextCourse : adjacencyMap.get(course)){
                    indegree[nextCourse]--;
                    if(indegree[nextCourse] == 0){
                        queue.offer(nextCourse);
                    }
                }
            }

            return learnedcourse == numCourses;
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
