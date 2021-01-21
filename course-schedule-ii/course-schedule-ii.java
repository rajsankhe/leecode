class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int indegree[] = new int[numCourses];
        Map<Integer, List<Integer>> graph = buildGraph(numCourses, prerequisites, indegree);
        int completedCourses = 0;
        
        int [] courseOrder = new int[numCourses];
        int k = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i < numCourses; i++){
            if (indegree[i] == 0) {
                completedCourses++;
                courseOrder[k++] = i;
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int pre = queue.poll();
            if (graph.get(pre) != null){
                for(int course : graph.get(pre)) {
                indegree[course]--;
                if (indegree[course] == 0){
                    queue.add(course);
                    completedCourses++;
                    courseOrder[k++] = course;
                }
            }
            }
        }
        return completedCourses == numCourses ? courseOrder : new int[0];
    }
    
    public Map<Integer, List<Integer>> buildGraph(int numCourses, int[][] prerequisites, int indegree[]){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] link : prerequisites){
            if(!graph.containsKey(link[1]))
                graph.put(link[1], new ArrayList<>());
            graph.get(link[1]).add(link[0]);
            indegree[link[0]]++;
        }
        return graph;
    }
    
}
