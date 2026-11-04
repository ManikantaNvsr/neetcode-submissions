class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        // Since left of the first element is nothing
        result[0] = 1;
        // Store product of all left elements at each index
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        // Multiply and store product of all right elements at each index in the same result array
        // initially, it will be 1 since there is no element after last right.
        int productOfAllRightElements = 1;
        for (int i = nums.length - 1; i > -1; i--) {
            result[i] = result[i] * productOfAllRightElements;
            // For the next iteration, this will be product of all right elements
            productOfAllRightElements = productOfAllRightElements * nums[i];
        }
        return result;
    }
}  
