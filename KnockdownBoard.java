import java.util.*;
public class KnockdownBoard {
    
    static int H,W;
    static int[][] scores;
    static int[][] maxScore; //[i][j]を最下段としたときの最大得点
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();
        scores = new int[H][W];
        maxScore = new int[H][W];
        
        for(int i = 0; i < H; i++){ //スコア読み込み
            for(int j = 0; j < W; j++){
                scores[i][j] = sc.nextInt();
            }
        }
        int result = 0;
        
        for(int j = 0; j < W; j++){
            result = Math.max(result, dfs(H - 1, j));
        }
        System.out.println(result);
    }
    
    static int dfs(int i, int j){//(i.j)を最下段としたときの最大得点を返す
        if(maxScore[i][j] > 0){
            return maxScore[i][j];
        }
        int currentScore = scores[i][j];
        
        if(i > 0){
            int maxChildScore = 0;
            maxChildScore = Math.max(maxChildScore, dfs(i - 1,j));
            if (j > 0){
                maxChildScore = Math.max(maxChildScore, dfs(i - 1,j - 1));
            }
            if(j < W -1){
                maxChildScore = Math.max(maxChildScore, dfs(i - 1,j + 1));
            }
            currentScore += maxChildScore;
        }
        maxScore[i][j] = currentScore;
        return currentScore;
    }
}

/*入力例
3 4
1 1 2 1
2 1 1 2
2 1 1 2*/
