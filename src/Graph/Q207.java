package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q207 {
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
