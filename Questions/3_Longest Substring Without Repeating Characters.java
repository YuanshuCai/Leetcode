class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        Set<Character> seen = new HashSet<>();
        int slow = 0, f = 0;
        int globalMax = 0;
        while(f < arr.length){
            if (seen.contains(arr[f])){
                seen.remove(arr[slow++]);
            } else {
                seen.add(arr[f]);
                f++;
                globalMax = Math.max(globalMax, f - slow);
            }
        }
        return globalMax;
       
    }
}