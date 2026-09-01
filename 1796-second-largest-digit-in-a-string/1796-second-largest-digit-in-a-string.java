class Solution {
    public int secondHighest(String s) {
        char arr[]=s.toCharArray();
        int n=arr.length;
        int max=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int num=0;
        for(int i=0;i<n;i++){
            if(Character.isDigit(arr[i])){
                num = arr[i] - '0';
                if(num>max){
                    max2=max;
                    max=num;
                }
                else if(num>max2&&num<max){
                    max2=num;
                }
            }
        }
        return (max2==Integer.MIN_VALUE)?-1:max2;
    }
}