/**
* Input: nums = [4,5,6,7,0,1,2], target = 0
* Output: 4
*/

class Solution {
    public int search(int[] nums, int target) {
      
        int index = -1;
		int length = nums.length - 1;
		int start = 0;
		int end = length;

    
        if(length == -1)
            ;    
		else if (nums[start] <= nums[end]) {
			index = findIndex(nums, start, end, target);
		} else {

			while (start <= end) {
				int mid = start + (end - start) / 2;

				if (mid + 1 <= end && nums[mid] > nums[mid + 1]) {
					if (nums[0] <= target && nums[mid] >= target) {
						index = findIndex(nums, 0, mid, target);
					} else {
						index = findIndex(nums, mid + 1, length, target);
					}
					break;
				} else if (mid - 1 >= start && nums[mid] < nums[mid - 1]) {
					if (nums[0] <= target && nums[mid-1] >= target) {
						index = findIndex(nums, 0, mid - 1, target);
					} else {
						index = findIndex(nums, mid, length, target);
					}
					break;
				}
				if (nums[start] > nums[mid]) {
					end = mid - 1;
				} else
					start = mid + 1;
			}
		}

		return index;
        
        
    }
    
    public int findIndex(int[] nums, int start, int end, int target) {

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (nums[mid] == target)
				return mid;

			if (nums[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return -1;
	}
}
