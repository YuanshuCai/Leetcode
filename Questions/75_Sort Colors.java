
class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int i = 0, j = 0;
        int k = nums.length -1;
        while (j <= k){
            if(nums[j] == 0){
                swap(nums, i, j);
                i++;
                j++;
            } else if (nums[j] == 1){
                j++;
            } else {//==2
                swap(nums, k, j);
                k--;
            }
        }
        return;
    }
    private void swap (int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] =tmp;
    }
}