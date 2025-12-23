class Solution {
  public List<List<Integer>> res = new ArrayList<>();
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    backtrack(candidates, target, new ArrayList<Integer>(), 0, 0);
    return res;
  }
  public void backtrack(int[] candidates, int target, List<Integer> currList, int cumSum, int lastIndex) {
    for (int i=lastIndex;i<candidates.length;i++) {
      int candidate = candidates[i];
      if (cumSum + candidate > target) {
        break;
      }
      List<Integer> newList = new  ArrayList<>(currList);
      newList.add(candidate);
      if (cumSum + candidate == target) {
        res.add(newList);
      } else {
        dfs(candidates, target, newList, cumSum+candidate, i);
      }
    } 
  }
}
