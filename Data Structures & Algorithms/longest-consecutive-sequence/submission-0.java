class Solution {
    public int longestConsecutive(int[] nums) {
        // Load to set
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int max = 0;
        for (int num : set) {
            // Find the start of a sequence
            if (!set.contains(num - 1)) {
                int count = 0;
                // Calculate sequence length
                while (set.contains(num)) {
                    count++;
                    num = num + 1;
                }
                // Store it to max
                max = Math.max(count, max);
            }
        }
        return max;
    }
}
