// Problem 2
//Course Schedule (https://leetcode.com/problems/course-schedule/)


// Time Complexity :O(vertices+edges)
// Space Complexity :O(vertices+edges)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//bfs using topological sort=> use a hasmap to store independent to dependent node maping
//use a array to store frequency (topological sort)
//now add each node with 0 frequency to queue and keep reducing frequency from the array of all dependent nodes
//do it until queue is empty and see if by the time queue is empty were all courses taken.
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] frequency = new int[numCourses];
        Map<Integer,List<Integer>> map1=new HashMap<>();
        for(int i=0; i<prerequisites.length;i++){
            frequency[prerequisites[i][0]]++;
            if(!map1.containsKey(prerequisites[i][1])) map1.put(prerequisites[i][1], new ArrayList<>());
            map1.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> bfs = new LinkedList<>();
        int count =0;
        for(int i=0; i<frequency.length; i++){
            if(frequency[i]==0) {bfs.add(i);
            count++;}
        }
        while(!bfs.isEmpty()){
            int course = bfs.poll();
            if( map1.get(course) == null) continue;
            List<Integer> reduce = map1.get(course);
            for(int i=0; i<reduce.size(); i++){
                frequency[reduce.get(i)]--;
                if(frequency[reduce.get(i)]==0){
                    count++;
                    bfs.add(reduce.get(i));
                    if(count==numCourses) return true;
                }
            }
        }
        return count==numCourses;
    }
}
