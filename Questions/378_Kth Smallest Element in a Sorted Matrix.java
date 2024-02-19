class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> matrix[a.i][a.j] - matrix[b.i][b.j]);
        boolean[][] visited = new boolean[n][n]; // To keep track of visited cells
        
        pq.offer(new Cell(0, 0));
        visited[0][0] = true;
        
        while (k > 1) {
            Cell cell = pq.poll();
            int i = cell.i;
            int j = cell.j;
            
            if (i + 1 < n && !visited[i + 1][j]) {
                pq.offer(new Cell(i + 1, j));
                visited[i + 1][j] = true;
            }
            if (j + 1 < n && !visited[i][j + 1]) {
                pq.offer(new Cell(i, j + 1));
                visited[i][j + 1] = true;
            }
            
            k--;
        }
        
        return matrix[pq.peek().i][pq.peek().j];
    }
    
    class Cell {
        int i;
        int j;
        
        Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
