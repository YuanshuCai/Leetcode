class Solution {
    public String removeDuplicates(String s, int k) {
        int i = 0, n = s.length();
        int[] count = new int[n];
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()){
            sb.append(c);
            int index = sb.length() - 1;
            if (index > 0 && sb.charAt(index) == sb.charAt(index - 1)){
                count[index] = count[index - 1] + 1;
            } else {
                count[index] = 1;
            }
            if (count[index] >= k) {
                sb.delete(sb.length() - k, sb.length());
            }
        }
        return sb.toString();
    }
}