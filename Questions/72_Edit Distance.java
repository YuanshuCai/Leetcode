class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
         for (int i = 0; i <= l1; i++){
            for (int j = 0; j <= l2; j++){
                if (i == 0){
                    dp[i][j] = j;
                } else if (j == 0){ //basecase when i/j = 0 
                    dp[i][j] = i;
                } else if (word1.charAt(i - 1) == word2.charAt(j -1)){
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j],dp[i][j -1])) + 1;
                }
            }
        }
        return dp[l1][l2];
    }
}