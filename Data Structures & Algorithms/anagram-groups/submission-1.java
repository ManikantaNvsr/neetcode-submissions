class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new LinkedList();
        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String anagram = new String(charArr);
            if (map.containsKey(anagram)){
                map.get(anagram).add(str);
            }
            else {
                List<String> list = new LinkedList(){{
                   add(str);
                }};
                map.put(anagram, list);
            }
        }
        return new LinkedList(map.values());
    }
}
