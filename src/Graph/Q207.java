package Graph;

import java.util.*;

public class Q207 {
    class Solution4 {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            //create the adjacency map: key -> pre course / value -> can take course
            Map<Integer,Set<Integer>> adjacencyMap = new HashMap<>();
            // int[] record the numbers of pre course
            int[] indegree = new int[numCourses];

            //traversal the map to new a hashset
            for(int i = 0; i < numCourses; i++){
                adjacencyMap.put(i, new HashSet<>());
            }

            //translate the prerequisites to adjacencyMap
            for(int[] prerequisite : prerequisites){
                int course = prerequisite[0];
                int preCourse = prerequisite[1];
                adjacencyMap.get(preCourse).add(course);
                //update the indegree
                indegree[course]++;
            }

            //add all indegree == 0 course to a queue
            Queue<Integer> queue = new LinkedList<>();
            // for(int i : indegree){
            //     if(i == 0){
            //         queue.add(indegree[i]); 错误写法：queue 里面放的是课程 不是value 课程是index
            //     }
            // }
            for(int i = 0; i < numCourses ; i++){
                if(indegree[i] == 0){
                    queue.add(i);
                }

            }

            //poll course from queue and add recourd the couse numbers
            int allCourseNum = 0;
            while(!queue.isEmpty()){
                int canTakeCourse = queue.poll();
                allCourseNum++;

                //check the next can take course
                for(int nextCourse: adjacencyMap.get(canTakeCourse)){
                    indegree[nextCourse]--;
                    if(indegree[nextCourse] == 0){
                        queue.add(nextCourse);
                    }
                }
            }

            return allCourseNum == numCourses;
        }
    }
    class Solution3 {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            //adjacency map - preCourse Course
            //错误写法：int[integer],set<Integer>
            Map<Integer,Set<Integer>> adjacencyMap = new HashMap<>();
            for(int i = 0; i < numCourses; i++){
                adjacencyMap.put(i,new HashSet<>());//?
            }

            //array - indegree of the class
            //错误写法：int<Integer> indegree = new int[];
            int[] indegree = new int[numCourses];

            //put all data
            for(int[] prerequisite: prerequisites){
                int course = prerequisite[0];
                int preCourse = prerequisite[1];
                //注意：map.get之后是一个set
                adjacencyMap.get(preCourse).add(course);
                indegree[course]++;
            }

            //queue - indegree == 0
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < numCourses; i++){
                if(indegree[i] == 0){
                    queue.offer(i);
                }
            }

            //count the can finished course - poll the queue and check the nextclass
            int finishedCourse = 0;
            while(!queue.isEmpty()){
                int canTakeCourse = queue.poll();
                finishedCourse++;

                for(int nextCourse : adjacencyMap.get(canTakeCourse)){
                    indegree[nextCourse]--;
                    if(indegree[nextCourse] == 0){
                        queue.offer(nextCourse);
                    }
                }
            }
            return finishedCourse == numCourses;
        }
    }

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
