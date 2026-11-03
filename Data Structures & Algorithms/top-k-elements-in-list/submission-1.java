class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // The optimal solution for this problem follows count based Bucket Sort
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        // frequency of the most repeated element will not exceed the size of the array.
        List<Integer>[] listArr = new List[nums.length + 1];
        for (int i = 0; i < listArr.length; i++) {
            listArr[i] = new LinkedList<>();
        }
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            listArr[entry.getValue()].add(entry.getKey());
        }
        int[] result = new int[k];
        int index = 0;
        for (int i = listArr.length - 1; i > -1; i--) {
            if (listArr[i] != null) {
                for (int x : listArr[i]) {
                    result[index++] = x;
                    if (index == k) {
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
