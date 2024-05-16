import java.util.*;
public class donut {
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();
        
        char[][] pat = new char[H][W];
        for (int i = 0; i<H; i++){
            String row = sc.next();
            for(int j = 0; j < W; j++){
                pat[i][j] = row.charAt(j);
            }
        }
        int count = countDonuts(pat, H, W);
        System.out.println(count);
    }
    public static int countDonuts(char[][] pat, int H, int W) {
        int count = 0;
        
        // 2重ループで各マスをチェック
        for (int i = 1; i < H - 1; i++) {
            for (int j = 1; j < W - 1; j++) {
                // 中心のマスが白でない場合はスキップ
                if (pat[i][j] != '.') {
                    continue;
                }
                
                // 中心のマスを囲む8マスがすべて黒かチェック
                if (pat[i-1][j-1] == '#' && pat[i-1][j] == '#' && pat[i-1][j+1] == '#' &&
                    pat[i][j-1] == '#' && pat[i][j+1] == '#' &&
                    pat[i+1][j-1] == '#' && pat[i+1][j] == '#' && pat[i+1][j+1] == '#') {
                    count++;
                }
            }
        }
        return count;
    }
}

/*入力例
6 4
####
#..#
#..#
####
#.##
####
 */