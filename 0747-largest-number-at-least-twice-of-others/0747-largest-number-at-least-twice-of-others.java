class Solution {
    public int dominantIndex(int[] nums) {
        int max=nums[0];
        int idx=0;
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i] > max){
                max = nums[i];
                idx = i;
            }
        }
       Arrays.sort(nums);
       if(nums[n-2]*2<=max)
        return idx;
        else return -1;
    }
}