class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        HashSet<Integer> used = new HashSet<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < routes.length; i++)
            for (int j = 0; j < routes[i].length; j++) {
                graph.putIfAbsent(routes[i][j], new LinkedList<>());
                graph.get(routes[i][j]).add(i);
            }
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        int r = 1;
        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; size--)
                for (int bus : graph.get(q.poll()))
                    if (used.add(bus))
                        for (int j = 0; j < routes[bus].length; j++)
                            if (routes[bus][j] == target)
                                return r;
                            else q.offer(routes[bus][j]);
            r++;
        }
        return -1;
    }
}