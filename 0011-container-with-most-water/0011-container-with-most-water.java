class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int i=0,j=n-1;
        int max=0;
        while(i<j){
            int h=Math.min(height[i],height[j]);
            int w=j-i;
            int a=h*w;
            max=Math.max(max,a);
            if(height[i]<height[j]) i++;
            else
            j--;
        }
        return max;
    }
}