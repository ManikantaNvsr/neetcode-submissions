class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (set.contains(complement)) {
                res[0] = i;
                for (int j = i+1; j < nums.length; j++) {
                    if (complement == nums[j]){
                        res[1] = j;
                        return res;
                    }
                }
            }
        }
        return res;
    }
}
