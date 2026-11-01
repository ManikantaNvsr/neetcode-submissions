class Solution {
    public boolean isPalindrome(String s) {

        // Remove all non-alphanumeric characters
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();

        System.out.println(s);

        // Edge Cases
        if (s.isEmpty() || s.length() == 1) {
            return true;
        }
        char[] charArr = s.toCharArray();
        int left = 0;
        int right = charArr.length - 1;
        while (left < right) {
            if (charArr[left++] != charArr[right--]) {
                return false;
            }
        }
        return true;
    }
}
