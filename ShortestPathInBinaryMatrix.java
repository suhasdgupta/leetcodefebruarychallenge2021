class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;
            if (grid[0][0] == 1 || grid[N - 1][N - 1] == 1) // if starting/ending point blocked.
                return -1;
            Set<Integer> seen = new HashSet<>(Arrays.asList(0)); // avoid duplicates. 
            Queue<Integer> q = new LinkedList<>(seen);
            for (int steps = 1; !q.isEmpty(); ++steps) { // increase one per round of search.
                for (int sz = q.size(); sz > 0; --sz) { // breadth control.
                    int x = q.peek() / N, y = q.poll() % N; // decode.
                    if (x == N - 1 && y == N - 1)  // find shortest path.
                        return steps; // return its length. 
                    for (int i = x - 1; i <= x + 1; ++i) {  // traverse 8 neighbors of (x, y)
                        for (int j = y - 1; j <= y + 1; ++j) { // (i, j) is neighbor's coordinates.
                            if (i >= 0 && i < N && j >= 0 && j < N && grid[i][j] == 0 && seen.add(i * N + j)) {
                                q.offer(i * N + j); // add it into queue if it is valid, neither blocked nor visited.
                            }
                        }
                    }
                }
            }
            return -1;
        
    }
}
