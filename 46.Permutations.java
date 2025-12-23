class Solution {
    public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> res = new ArrayList<>();
      backtrack(res, nums, new ArrayList<Integer>());
      return res;
    }
    public void backtrack(List<List<Integer>> res, int[] nums, List<Integer> currRes) {
      if (currRes.size() == nums.length) {
        res.add(new ArrayList<>(currRes));
        return;
      }
      for (int i=0;i<nums.length;i++) {
        if (currRes.contains(nums[i])) {
          continue;
        }
        currRes.add(nums[i]);
        backtrack(res, nums, currRes);
        currRes.remove(currRes.size()-1);
      }
    }
}
