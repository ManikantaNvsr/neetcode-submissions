class Solution {

    public String encode(List<String> strs) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strs) {
            stringBuilder.append(str.length()).append("#").append(str);
        }
        return stringBuilder.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        char[] charArr = str.toCharArray();
        int index = 0;
        while (index < charArr.length) {
            // goes until it meets #
            StringBuilder lengthBuilder = new StringBuilder();
            while (charArr[index] != '#') {
                lengthBuilder.append(charArr[index++]);
            }
            int length = Integer.parseInt(lengthBuilder.toString());
            result.add(str.substring(index + 1, index + length + 1));
            index = index + length + 1;
        }
        return result;
    }
}
