
class Solution {
  public enum Pos {
      A,
      B
  }
  public record Frame(TreeNode node, Pos pos){}
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Stack<Frame> st = new Stack<>();
    st.push(root, Pos.A);
    while (!st.isEmpty()) {
      Frame fr = st.pop();
      if (fr.pos == Pos.A) {
        if (fr.node == null) continue;
        st.push(new Frame(fr.node.right, Pos.A));
        st.push(new Frame(fr.node, Pos.B);
        st.push(new Frame(fr.node.left, Pos.A));
      } else if (fr.pos == Pos.B) {
        res.add(fr.node.val);
      }
    }
    return res;
  }
}
