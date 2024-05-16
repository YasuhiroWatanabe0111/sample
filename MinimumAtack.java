import java.util.*;

public class MinimumAtack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1行目: AとBを読み込む
        int A = sc.nextInt(); // 単体攻撃力
        int B = sc.nextInt(); // 全体攻撃力

        // 2行目: Nを読み込む
        int N = sc.nextInt(); // モンスターの数

        // 3行目: 各モンスターのHPを読み込む
        int[] monstersHP = new int[N];
        for (int i = 0; i < N; i++) {
            monstersHP[i] = sc.nextInt();
        }

        // 最小の攻撃回数を求める
        long minAttacks = Long.MAX_VALUE; // 最小攻撃回数の初期値を最大値で初期化

        // 全体攻撃の回数を決定する
        for (int fullAttacks = 0; fullAttacks <= N; fullAttacks++) {
            // 全体攻撃回数が fullAttacks 回の場合の攻撃回数を計算
            int attacks = fullAttacks; // 全体攻撃回数
            int remainingHP = 0; // 残りのモンスターの合計HP

            // 全体攻撃で倒せるモンスターの数をカウント
            for (int hp : monstersHP) {
                if (hp > B * fullAttacks) {
                    remainingHP += hp - B * fullAttacks;
                }
            }

            // 残りのモンスターを単体攻撃で倒す必要がある場合の攻撃回数を加算
            attacks += (int) Math.ceil((double) remainingHP / A);

            // 最小攻撃回数を更新
            if (attacks < minAttacks) {
                minAttacks = attacks;
            }
        }

        // 結果を出力
        System.out.println("");
        System.out.println(minAttacks);

        sc.close();
    }
}

/*
入力フォーマット
A B
N
h_1 h_2 ... h_N
 */