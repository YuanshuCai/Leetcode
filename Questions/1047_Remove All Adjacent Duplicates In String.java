class Solution {
    public String removeDuplicates(String s) {
        if (s.length() == 1) return s;
        char[] arr = s.toCharArray();
        int slow = 0, fast = 1;
        while (fast < arr.length){
            if (slow >= 0 && arr[slow]==arr[fast]){//there is adjacent duplicates between slow and fast
                slow--;
                fast++;
            }else {
                slow++;
                arr[slow] = arr[fast];
                fast++;
            }
        }
        return new String(arr, 0, slow + 1);

    }
}
/*
 abbbaaca
 s
  f

*/