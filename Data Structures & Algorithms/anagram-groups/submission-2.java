class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // This solution works because we know that all the input strings contains only lowercase
        // Otherwise, it is better to use the sorting approach
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] freqArr = new int[26];
            for (char c : str.toCharArray()){
                freqArr[c - 'a']++;
            }
            String key = Arrays.toString(freqArr);
            map.putIfAbsent(key, new LinkedList());
            map.get(key).add(str);
        }
        return new LinkedList(map.values());
    }
}
