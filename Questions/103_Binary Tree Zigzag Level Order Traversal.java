// O(N) where N is the number of nodes in the tree
// Solution 1:
// - Uses a regular queue for level order traversal.
// - Adds elements to the result list based on the level's parity (odd/even).
// - Manages the direction of adding elements by checking the level's parity.

class Solution1 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // Create a list to store the result (zigzag level order traversal)
        List<List<Integer>> ans = new ArrayList<>();

        // Check if the root is null, if so, return an empty list
        if (root == null) return ans;

        // Create a double-ended queue for level order traversal
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // Variable to track whether the current level is odd or even
        boolean isOdd = false;

        // Continue traversal until all nodes are processed
        while (!q.isEmpty()) {
            // Get the size of the current level
            int levelSize = q.size();

            // List to store the current level elements
            List<Integer> curLevel = new ArrayList<>();

            // Process each node at the current level
            for (int i = 0; i < levelSize; i++) {
                // Depending on whether the level is odd or even, process nodes differently
                if (isOdd == true) { // If the level is odd, process nodes from the front of the queue
                    TreeNode cur = q.pollFirst();
                    curLevel.add(cur.val);

                    // Add the right and left child nodes to the end of the queue if they exist
                    if (cur.right != null) q.offerLast(cur.right);
                    if (cur.left != null) q.offerLast(cur.left);
                } else { // If the level is even, process nodes from the end of the queue
                    TreeNode cur = q.pollLast();
                    curLevel.add(cur.val);

                    // Add the left and right child nodes to the front of the queue if they exist
                    if (cur.left != null) q.offerFirst(cur.left);
                    if (cur.right != null) q.offerFirst(cur.right);
                }
            }

            // Toggle the isOdd flag for the next level
            isOdd = !isOdd;

            // Add the current level list to the result list
            ans.add(curLevel);
        }

        // Return the final result
        return ans;
    }
}
// Solution 2:
// - Uses a double-ended queue (Deque) for level order traversal.
// - Determines the direction of adding elements based on a boolean flag (isOdd).
// - Processes nodes differently based on whether the level is odd or even.
// - Offers and polls elements from either end of the deque to achieve zigzag traversal.

class Solution2 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // Create a list to store the result (zigzag level order traversal)
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        // Check if the root is null, if so, return an empty list
        if (root == null) return ans;
        
        // Create a queue for level order traversal
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        // Variable to track the current level
        int level = 0;
        
        // Iterate through the tree using level order traversal
        while (!queue.isEmpty()){
            // Get the size of the current level
            int levelSize = queue.size();
            
            // List to store the current level elements
            List<Integer> curLevel = new ArrayList<Integer>();
            
            // Process each node at the current level
            for (int i = 0; i < levelSize; i++){
                // Remove the node from the front of the queue
                TreeNode cur = queue.poll();              
                
                // Depending on the level, add the node's value to the current level list
                if (level % 2 != 1){
                    // If the level is even, add the value to the end of the list
                    curLevel.add(cur.val);
                } else {
                    // If the level is odd, add the value to the beginning of the list
                    curLevel.add(0, cur.val);
                }
                
                // Add the left and right child nodes to the queue if they exist
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            
            // Increment the level counter
            level++;
            
            // Add the current level list to the result list
            ans.add(curLevel);
        }
        
        // Return the final result
        return ans;
    }
}
