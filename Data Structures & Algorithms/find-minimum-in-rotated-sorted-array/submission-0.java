class Solution {
    public int findMin(int[] nums) {


        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } else if (nums[mid] > nums[left]) {
                left = mid;
            } else {
                right = mid;
            }

        }
        return nums[0];
    }
}
