class Solution {
    public boolean isAnagram(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(n!=m) return false;
        char sa[]=s.toCharArray();
        char ta[]=t.toCharArray();
        Arrays.sort(sa);
        Arrays.sort(ta);
        for(int i=0;i<n;i++){
            if(sa[i]!=ta[i]) return false;
        }
        return true;
    }
}