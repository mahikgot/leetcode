class Solution {
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length-1;
    while (left < right) {
      int mid = left + ((right-left)/2);
      if (nums[left] <= nums[mid]) {
        //left sorted
        if (nums[left] <= target && target <= nums[mid]) {
          right = mid;
        } else {
          left = mid+1; 
        }
      } else {
        // right sorted
        if (nums[mid] <= target && target <= nums[right]) {
          left = mid;
        } else {
          right = mid-1;
        }
      }
    }
    return nums[left] == target ? left : -1;
  }
}
