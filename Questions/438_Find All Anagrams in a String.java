class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans =  new ArrayList<Integer>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++){
            map.put(p.charAt(i),map.getOrDefault(p.charAt(i),0) + 1);
        }
        int matchSize = map.size();
        int start = 0;
        int end = 0;
        while (end < s.length()){
            char curChar = s.charAt(end);
            if(map.containsKey(curChar)){
                int count = map.get(curChar);
                if (count == 1){
                    matchSize--;
                }
                map.put(curChar, count - 1);
            }
            end ++;
            if (start < end - p.length()){
                char sChar = s.charAt(start);
                if (map.containsKey(sChar)){
                    int count = map.get(sChar);
                    if (count == 0){
                        matchSize++;
                    }
                    map.put(sChar, count + 1);
                }
                start++;
            }
            if (matchSize == 0){
                ans.add(start);
            } 
        }
        return ans;
    }
}