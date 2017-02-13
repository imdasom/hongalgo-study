import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by yhk on 16. 12. 21..
 * url:https://www.acmicpc.net/problem/11724
 */
public class DFS_11724 {
    static int N, K;
    static int[][] baseArr;
    static int[][] visitArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        baseArr = new int[N + 1][N + 1];
        visitArr = new int[N + 1][N + 1];

        for (int i = 0; i < K; i++) {
            String[] index = br.readLine().split(" ");
            baseArr[Integer.parseInt(index[0])][Integer.parseInt(index[1])] = 1;
            baseArr[Integer.parseInt(index[1])][Integer.parseInt(index[0])] = 1;
        }

        int cnt = 0;
        for (int x = 0; x < N + 1; x++) {
            int noConnect = 0;
            for (int y = 0; y < N + 1; y++) {
                if (baseArr[x][y] == 0 && x != 0) {
                    noConnect++;
                }
                if (baseArr[x][y] == 1 && visitArr[x][y] == 0) {
                    visitArr[x][y] = 1;
                    dfs(y);
                    cnt++;
                }
            }

            if (noConnect == N + 1) {
                cnt++;
            }
        }
        br.close();
        System.out.print(cnt);

    }

    public static void dfs(int y) {
        for (int i = 0; i < N + 1; i++) {
            if (baseArr[y][i] == 1 && visitArr[y][i] == 0) {
                visitArr[y][i] = 1;
                dfs(i);
            }

        }
    }
}
