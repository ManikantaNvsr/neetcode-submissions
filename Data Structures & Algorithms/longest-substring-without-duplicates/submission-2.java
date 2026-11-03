class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;
        Set<Character> set = new HashSet<>();
        int end = 0;
        while (end < s.length()) {
            char ch = s.charAt(end);
            if (set.contains(ch)) {
                max = Math.max(max, end - start);
                while (s.charAt(start) != s.charAt(end)) {
                    set.remove(s.charAt(start));
                    start++;
                }
                set.remove(s.charAt(start));
                start = start + 1;
            }
            set.add(ch);
            end++;
        }
        return Math.max(max, end - start);
    }
}

