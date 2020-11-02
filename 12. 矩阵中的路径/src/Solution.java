import org.junit.jupiter.api.Test;

public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.equals("")) return true;
        if (board == null || board.length * board[0].length < word.length()) return false;
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //对于当前元素进行递归
                if (dfsWithBacktrack(board,words,i,j,0)) return true;
            }
        }
        return false;
    }

    /**
     * 深度优先遍历(不回溯)
     * 该方法时间开销大
     *
     * @param board 字母矩阵
     * @param words 待检测单词
     * @param i     行
     * @param j     列
     * @param index 待检测单词数组索引
     * @return boolean
     */
    private boolean dfs(char[][] board,char[] words,int i,int j,int index){
        //边界条件的判断
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0) return false;//越界
        if (board[i][j] != words[index]) return false;//此路不通
        if (index == words.length - 1) return true;//word中的每个字符都检查完了，说明已经找到路径了
        //由于数组是引用传递，因此为了防止原数组被污染，需要复制一份
        char[][] boardCopy = copyArray(board);
        boardCopy[i][j] = '/';//已经遍历过的用“/”标识
        //往四个方向查找，只要有一个方向能走通，就返回true
        boolean res = dfs(boardCopy,words,i+1,j,index+1) //右
                || dfs(boardCopy,words,i-1,j,index+1) //左
                || dfs(boardCopy,words,i,j+1,index+1) //下
                || dfs(boardCopy,words,i,j-1,index+1);//上
        return res;
    }

    private char[][] copyArray(char[][] word){
        char[][] res = new char[word.length][word[0].length];
        for (int i = 0; i < word.length; i++) {
            for (int j = 0; j < word[0].length; j++) {
                res[i][j] = word[i][j];
            }
        }
        return res;
    }

    /**
     * 深度优先遍历(回溯)
     * 当沿着当前坐标往下传递的时候，把当前坐标的值修改，然后回归到当前坐标的时候再把当前坐标的值复原
     *
     * @param board 字母矩阵
     * @param words 待检测单词
     * @param i     行
     * @param j     列
     * @param index 待检测单词数组索引
     * @return boolean
     */
    private boolean dfsWithBacktrack(char[][] board,char[] words,int i,int j,int index){
        //边界条件的判断
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0) return false;//越界
        if (board[i][j] != words[index]) return false;//此路不通
        //如果word遍历完了，说明存在路径，返回true
        if (index == words.length - 1) return true;
        //将当前坐标存储起来
        char temp = board[i][j];
        //该位置已经被访问过
        board[i][j] = '/';
        //往四个方向递归
        boolean res = dfsWithBacktrack(board,words,i+1,j,index+1)
                || dfsWithBacktrack(board,words,i-1,j,index+1)
                || dfsWithBacktrack(board,words,i,j+1,index+1)
                || dfsWithBacktrack(board,words,i,j-1,index+1);
        //将坐标复原
        board[i][j] = temp;
        return res;
    }

    @Test
    public void test(){
        char[][] board = {{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
        String word = "bfce";
        boolean res = exist(board, word);
        System.out.println(res);

        char[][] board1 = {{'a','b'}};
        String word1 = "ba";
        boolean res1 = exist(board1, word1);
        System.out.println(res1);

        System.out.println(23/10+(23-23/10*10));
    }
}
