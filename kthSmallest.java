/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // inorder traversal for a BST processes from smallest to largest value
    // only need to process k times to get kth smallest

    enum Pos {
      A,
      B,
      C
    }
    record Frame(TreeNode node, Pos pos) {}
    public int kthSmallest(TreeNode root, int k) {
        Deque<Frame> st = new ArrayDeque<>();
        st.push(new Frame(root, Pos.A));
        int idx = 1;
        while (!st.isEmpty()) {
          Frame curr = st.pop();
          if (curr.node == null) continue;
          if (curr.pos == Pos.A) {
            st.push(new Frame(curr.node.right, Pos.A));
            st.push(new Frame(curr.node, Pos.B));
            st.push(new Frame(curr.node.left, Pos.A));
          } else {
            if (idx++ == k) return curr.node.val;
          }
        }
        return -1;
    }
}
