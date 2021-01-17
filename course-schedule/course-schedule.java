class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = buildGraph(numCourses, prerequisites);
        
        int visited[] = new int[numCourses];
        for(int i=0; i < numCourses; i++){
            if (isCyclic(i, visited, graph)) {
                return false;
            }
        }
        return true;
    }
    
    public Map<Integer, List<Integer>> buildGraph(int numCourses, int[][] prerequisites){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] link : prerequisites){
            if(!graph.containsKey(link[1]))
                graph.put(link[1], new ArrayList<>());
            graph.get(link[1]).add(link[0]);
        }
        return graph;
    }
    
    public boolean isCyclic(int i, int visited[], Map<Integer, List<Integer>> graph)      {
        if (visited[i] == 2)
            return true;
        visited[i] = 2;
        if (graph.containsKey(i)) {
            for(int j : graph.get(i)){
            if(isCyclic(j, visited, graph))
                return true;
        }
        }
        
        visited[i] = 1;
        return false;
    }
}
