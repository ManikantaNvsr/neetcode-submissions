class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // The problem comes down to 2sum if we fix one element of the triplet
        // At each iteration, we have to fix one element in the input
        // and find all the possible 2 sums with that element in the remaining array
        // After fixing the element, we could do two pointer approach to find the remaining two elements
        // Inorder to do the two pointer effectively,
        // we need to have the input in sorted order to avoid duplicate triplets

        // sort
        Arrays.sort(nums);

        // result
        List<List<Integer>> result = new LinkedList<>();

        // outer loop to fix one element
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // since we added them to the result
                    // the next left element shouldn't be same left element as previous
                    // similarly for the right
                    while (left < nums.length - 1 && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (right > 0 && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }

            // Similarly for the element we fix in the outer loop also should not be same as the previous one
            // That makes the program return a duplicate triplet
            // This condition is applied in coordination with the i++ in the loop
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }

        }
        return result;
    }
}
