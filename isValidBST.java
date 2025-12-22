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
    enum Pos {
      A, B
    }
    record Frame(TreeNode node, Pos pos) {}
    public boolean isValidBST(TreeNode root) {
        Deque<Frame> st = new ArrayDeque<>();
        st.add(new Frame(root, Pos.A));
        Integer last = null;
        while (!st.isEmpty()) {
          Frame curr = st.pop();
          if (curr.node == null) continue;
          if (curr.pos == Pos.A) {
            st.push(new Frame(curr.node.right, Pos.A));
            st.push(new Frame(curr.node, Pos.B));
            st.push(new Frame(curr.node.left, Pos.A));
          } else {
             if (last != null && last >= curr.node.val) return false;
             last = curr.node.val;
          }
        }
        return true;
    }
}
