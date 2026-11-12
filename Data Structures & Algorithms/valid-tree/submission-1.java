class Solution {

    // Feedback: You were able to write entire program independently
    // However, the block inside the DFS function became complex
    // and not handling the edge cases effectively
    // Took help to fix the DFS core logic.
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> adjacenyList = new HashMap<>();
        int[] visited = new int[n];
        boolean disconnectedComponents = false;

        // Iterate over the edges
        for (int[] edge : edges) {
            // 1
            Set<Integer> adjacentNodes = adjacenyList.getOrDefault(edge[0], new HashSet<>());
            adjacenyList.put(edge[0], adjacentNodes);
            adjacentNodes.add(edge[1]);

            // 2
            adjacentNodes = adjacenyList.getOrDefault(edge[1], new HashSet<>());
            adjacenyList.put(edge[1], adjacentNodes);
            adjacentNodes.add(edge[0]);
        }

        System.out.println("adjacenyList:" + adjacenyList);

        boolean cycleExists = dfs(0, adjacenyList, -1, visited);

        System.out.println("cycleExists: " + cycleExists);

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                disconnectedComponents = true;
                break;
            }
        }
        System.out.println("disconnectedComponents: " + disconnectedComponents);
        return !cycleExists && !disconnectedComponents;
    }

    public boolean dfs(int rootNode, Map<Integer, Set<Integer>> adjacentList, int parent, int[] visited) {

//        System.out.println("rootNode: " + rootNode);
//        System.out.println("parent: " + parent);
//        System.out.println("Visited: " + Arrays.toString(visited));

        // Mark the node as visited
        visited[rootNode] = 1;

        for (int x : adjacentList.getOrDefault(rootNode, Collections.emptySet())) {
            // ignoring the parent not we just traversed
            if (x == parent) {
                continue;
            }
            // Cycle detected
            if (visited[x] == 1) {
                return true;
            }
            // propagating the true value detected in the nested DFS calls
            if (dfs(x, adjacentList, rootNode, visited)) {
                return true;
            }
        }

        return false;
    }
}