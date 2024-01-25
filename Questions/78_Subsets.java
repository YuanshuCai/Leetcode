class Solution {
    /*
      Time Complexity: O(2^n)
Space Complexity: O(n)
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generateSubsets1(nums, 0, new ArrayList<>(), ans);
        return ans;
    }
    private void generateSubsets1(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            generateSubsets(nums, i + 1, current, result);
            current.remove(current.size() - 1); //subtracking
        }
    }
    
}

/*
generateSubsets1

                [""]
            /          \
           [a]           ""
          /   \          /   \
       [ab]    a      [b]     ""
        |       |      |       |
     [abc]    [ac]     [bc]    [c]
*/
/* generateSubsets2 2
                      ""
            /                \
           ""                   c
          /   \                /   \
        ""       b            ""     bc
      /  \     /  \          /  \    /  \
  [""]  [a]   [b] [ab]    [c]  [ac] [bc] [abc]

*/