class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        //base case
        dp[0] = dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
              //left possible * right possible
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
/*
1. pick a number j to be the parent node
2. #left tree Node = [0, j -1], #right tree Node[j + 1, n]
3. if I pick j as the parent node = left possible tree # * right possible tree #
 */