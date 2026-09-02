class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        double sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        double maxa=sum/k;
        
        for(int i=k;i<n;i++){
            sum=sum-nums[i-k]+nums[i];
            double avg=sum/k;
            maxa=Math.max(avg,maxa);
        }
        return maxa;
    }
}