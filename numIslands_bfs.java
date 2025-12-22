class Solution {
    public int numIslands(char[][] grid) {
      int res = 0;
      Deque<int[]> st = new ArrayDeque<>();
      for (int i=0;i<grid.length;i++) {
        for (int j=0;j<grid[0].length;j++) {
          if (grid[i][j] == '1') {
            res++;
            st.addLast(new int[]{i, j});
            while (!st.isEmpty()) {
              int[] curr = st.pop();
              if (curr[0] < 0 || curr[1] < 0 || curr[0]>=grid.length
                || curr[1] >= grid[0].length || grid[curr[0]][curr[1]] == '0') {
                continue;
              }
              grid[curr[0]][curr[1]] = '0';
              st.addLast(new int[]{curr[0]+1, curr[1]});
              st.addLast(new int[]{curr[0]-1, curr[1]});
              st.addLast(new int[]{curr[0], curr[1]+1});
              st.addLast(new int[]{curr[0], curr[1]-1});
            }
          }
        }
      }
      return res;
    }
}

