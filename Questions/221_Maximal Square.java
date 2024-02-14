class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][]dp = new int[n][m];
        //dp[i][j] physical meaning is largest side of square the current cell can form
        int globalMax = 0;
        for(int i = 0; i < n; i++){
            for (int j = 0; j < m ;j++){
                if (i == 0 || j== 0){
                    dp[i][j] = matrix[i][j] - '0';
                } else if (matrix[i][j] == '1'){
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j],dp[i][j -1]));
                }
                globalMax = Math.max(globalMax, dp[i][j]);
            }
        }
        return globalMax * globalMax;
    }
}