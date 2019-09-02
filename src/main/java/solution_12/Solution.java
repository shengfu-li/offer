package solution_12;

/**
 * 本质上就是一个深度优先遍历，但是注意：mark[currPosX][currPosY]=false;这句话一定要放在递归程序的return 语句后面，以防出现mark[currPosX][currPosY]无法还原的情况！
 */


public class Solution {
    static int [][]next={{-1,0},{0,1},{1,0},{0,-1}};
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        boolean [][]mark=new boolean[rows][cols];
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                mark[i][j]=true;
        char [][] table=makeTable(matrix,rows,cols);

        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++){
                boolean flag=travel(table,i,j,mark,rows,cols,0,str);
                if(flag) return true;
            }
        return false;
    }


    char [][] makeTable(char[] matrix,int rows,int cols){
        char [][] table=new char [rows][cols];
        for(int i=0,index=0;i<rows;i++)
            for(int j=0;j<cols;j++){
                table[i][j]=matrix[index++];
            }
        return table;
    }

    boolean travel(char[][] table, int currPosX,int currPosY,boolean[][]mark,int rows, int cols, int depth,char[] str){
        if(table[currPosX][currPosY]!=str[depth]) return false;
        if((depth==str.length-1)&&table[currPosX][currPosY]==str[depth]) {return true;}

        mark[currPosX][currPosY]=false;//注意，这句话一定要放在return 语句后面

        boolean flag=false;
        for(int i=0;i<4;i++){
            int nextPosX=currPosX+next[i][0];
            int nextPosY=currPosY+next[i][1];
            if(nextPosX>=0&&nextPosX<rows&&nextPosY>=0&&nextPosY<cols&&mark[nextPosX][nextPosY]==true){
                flag=travel(table,nextPosX,nextPosY,mark,rows,cols,depth+1,str);
                if(flag) break;
            }
        }
        mark[currPosX][currPosY]=true;
        return flag;
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        boolean flag=s.hasPath("ABCESFCSADEE".toCharArray(),3,4,"ABCCED".toCharArray());
        System.out.println(flag);
    }
}