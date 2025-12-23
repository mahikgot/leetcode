class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> res = new ArrayList<>();
    backtrack(res, candidates, target, new ArrayList<Integer>(), 0, 0);
    return res;
  }
  public void backtrack(List<List<Integer>> res, int[] nums, int target, List<Integer> currList, int cumSum, int last) {
    if (cumSum == target) {
      res.add(new ArrayList<>(currList));
      return;
    }
    for (int i=last;i<nums.length;i++) {
      if (cumSum + nums[i] > target) {
        return;
      }

      currList.add(nums[i]);
      backtrack(res, nums, target, currList, cumSum+nums[i], i);
      currList.remove(currList.size()-1);
    }
  }
}
