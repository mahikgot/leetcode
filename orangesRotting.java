class Solution {
    public int orangesRotting(int[][] grid) {
      int[][] dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
      int res = 0;
      Deque<int[]> st = new ArrayDeque<>();

      for (int i=0;i<grid.length;i++) {
        for (int j=0;j<grid[0].length;j++) {
          if (grid[i][j] == 2) {
            st.addLast(new int[]{i, j});
          }
        }
      }

      while(!st.isEmpty()) {
        boolean add = false;
        int size = st.size();
        for (int x=0;x<size;x++) {
          int[] curr = st.removeFirst();
          for (int[] dir: dirs) {
            int i = dir[0] + curr[0];
            int j = dir[1] + curr[1];
            if (i < 0 || j < 0 || i>=grid.length
              || j >= grid[0].length || grid[i][j] != 1) {
              continue;
            }
            add = true;
            grid[i][j] = 2;
            st.addLast(new int[]{i,j});
          }
        }
        if (add) res++;
      }
      for (int i=0; i<grid.length;i++) {
        for (int j=0; j<grid[0].length;j++) {
          if (grid[i][j] == 1) return -1;
        }
      }
      return res;
    }
}
