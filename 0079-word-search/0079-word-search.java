class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        int l=word.length();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(board,i,j,word,0)) return true;
            }
        }
        return false;
    }
    boolean dfs(char[][]board,int i,int j,String word,int k){
        int m=board.length;
        int n=board[0].length;
        if(i<0||j<0) return false;                                  //base cases
        if(i>=m||j>=n) return false;
        if(board[i][j]!=word.charAt(k)) return false;
        if(k==word.length()-1) return true;
        char temp=board[i][j];
        board[i][j]='#';                                            //visited
        boolean down=dfs(board,i+1,j,word,k+1);
        boolean up=dfs(board,i-1,j,word,k+1);
        boolean right=dfs(board,i,j+1,word,k+1);
        boolean left=dfs(board,i,j-1,word,k+1);

        board[i][j]=temp;
        return up||down||left||right;

    }
}