class Solution {
 // Time complexity: O((haystack.length() - needle.length()) * needle.length())
// The worst-case scenario is when we iterate through the haystack and compare each character

    public int strStr(String haystack, String needle) {
        int hayLength = haystack.length();
        int needleLength = needle.length();
        if (hayLength < needleLength) return -1;
        for (int i = 0; i <= hayLength -needleLength; i++){
            int j = 0;
            while(j < needleLength && haystack.charAt(i + j) == needle.charAt(j)){
                j++;
                if(j == needle.length()){
                    return i;
                } 
            }

        }
        return -1;
    }
}