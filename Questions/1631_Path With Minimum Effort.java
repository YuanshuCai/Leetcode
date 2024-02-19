class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0}); // {Effort, row, col}
        
    
        int[][] minEffort = new int[rows][cols];
        for (int[] row : minEffort)
            Arrays.fill(row, Integer.MAX_VALUE);
        minEffort[0][0] = 0;
        
        // Directions: up, down, left, right.
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int effort = curr[0];
            int row = curr[1];
            int col = curr[2];
            
            // If current effort is greater than what we have already found,
            // skip this cell.
            if (effort > minEffort[row][col])
                continue;
            
            // Reached the bottom-right cell, return the effort.
            if (row == rows - 1 && col == cols - 1)
                return effort;
            
            // Explore neighbors.
            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                // Check if the new position is within bounds.
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    // Calculate the effort required to move to the neighbor.
                    int newEffort = Math.max(effort, Math.abs(heights[newRow][newCol] - heights[row][col]));
                    
                    // If the new effort is less than what we have found before for this cell,
                    // update the minimum effort and add it to the priority queue.
                    if (newEffort < minEffort[newRow][newCol]) {
                        minEffort[newRow][newCol] = newEffort;
                        pq.offer(new int[]{newEffort, newRow, newCol});
                    }
                }
            }
        }
        
        return -1;
    }
}