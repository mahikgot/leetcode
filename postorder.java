class Solution {
  public enum Pos {
    A,
    B
  }
  public record Frame(TreeNode node, Pos pos) {}
  public List<Integer> postorderTraversal(TreeNode root) {
    var st = new Stack<Frame>();
    st.add(new Frame(root, Pos.A));
    while (!st.isEmpty()) {
      Frame curr = st.pop();
      if (curr.node == null) continue;
      if (curr.pos == Pos.A) {
        st.add(new Frame(curr.node, Pos.B));
        st.add(new Frame(curr.node.right, Pos.A));
        st.add(new Frame(curr.node.left, Pos.A));
      } else {
        res.add(curr.node.val);
      }
    }
  } 

  // private void dfs(TreeNode root) {
  //   if (root == null) return;
  //   dfs(root.left);
  //   dfs(root.right);
  //   res.add(root.val);
  // }
}
