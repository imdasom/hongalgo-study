package bj01012_dfs;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by dasom on 2016-12-27.
 */
public class Main {

    static int T, N, M, K;
    static int[][] arr;
    static boolean[][] visited;
    static int answer = 0;

    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(new FileInputStream("Baekjoon\\src\\bj01012_dfs\\input.txt")));
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int test_case = 0; test_case < T; test_case++) {
            initValues();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(arr[i][j] == 1 && !visited[i][j]){
                        DFS(i, j);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
            answer = 0;
        }

        br.close();
    }

    public static void DFS(int i, int j){
        int tempi = i;
        int tempj = j;
        if(i < 0 || i >= N || j < 0 || j >= M) return;
        if(arr[i][j]==0 || visited[i][j]) return;

        visited[i][j] = true;

        DFS(i - 1, j);
        DFS(i + 1, j);
        DFS(i, j - 1);
        DFS(i, j + 1);
    }

    public static void initValues() throws IOException {

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            arr[row][col] = 1;
        }
    }
}