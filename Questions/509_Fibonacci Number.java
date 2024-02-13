class Solution {
    private Map<Integer, Integer> ans = new HashMap<>();
    public int fib(int n) {
        if (n <= 1) return n;
        if (ans.containsKey(n)) return ans.get(n);
        int cur = fib(n - 1) + fib(n - 2);
        ans.put(n, cur);
        return cur;
    }
    /*
    public int fib(int n) {
        if (n <= 1) return n;
        int[] ans = new int[n + 1];
        ans[0] = 0;
        ans[1] = 1;
        for (int i = 2; i < n + 1; i ++){
            ans[i] = ans[i - 1] + ans[i - 2];
        }
        return ans[n];
    }
    */
}