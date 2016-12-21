package bj10026_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by pc on 2016-12-21.
 */
public class Main {
    static int N;
    static char[][] adj;

    static int startI = 0;
    static int startJ = 0;

    static char curColor;
    static boolean isNonRed = false;

    // [좌, 우, 상, 하] 순서
    static int[] dirI = {0, 0, 1, -1};
    static int[] dirJ = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        initValues();

        int counterRed = 0;
        int counterNonRed = 0;

        while (getStartPoint()) {
            DFS(startI, startJ);

            // 시작점 startI, startJ를 통해 한 번 DFS를 하고 빠져나오면 더 이상 인접한 같은 색이 없다는 것이므로
            // counterRed를 증가시킨다.
            counterRed++;
        }

        isNonRed = true;
        startI = startJ = 0;
        while (getStartPoint()) {

            DFS(startI, startJ);

            // 시작점 startI, startJ를 통해 한 번 DFS를 하고 빠져나오면 더 이상 인접한 같은 색이 없다는 것이므로
            // counterNonRed를 증가시킨다.
            counterNonRed++;
        }

        System.out.printf("%d %d\n", counterRed, counterNonRed);
    }

    private static void DFS(int i, int j) {


        for (int k = 0; k < 4; k++) {
            boolean continueFlag = true;
            // DFS를 하다가 더 이상 같은 색의 인접노드가 없으면 continueFlag가 false가 된다.
            // false가 되면 처음 위치를 기준으로 다음 인접노드를 검사한다.
            while (continueFlag) {
                continueFlag = searchSameColorDFS(i + dirI[k], j + dirJ[k]);
            }
        }
    }

    private static boolean searchSameColorDFS(int i, int j) {

        // 유효한 값인지 검사
        if (i < 0 || i >= N || j < 0 || j >= N) {
            return false;
        }

        char target = adj[i][j];

        // 같은 색인지 검사. 적록색약인 사람과 그렇지 않은 사람의 경우로 나눈다.
        if (isNonRed) {
            // 대문자이면 방문한 것
            if(target < 'a') return false;

            switch(curColor){
                case 'b':
                    if(curColor != target) return false;
                    break;

                case 'r':
                case 'g':
                    if(target == 'b') return false;
                    break;
            }
            // 같은 색의 노드라면 다음 노드를 탐색한다.
            adj[i][j] -= 32;
            DFS(i, j);
            return true;

        } else {
            // 소문자이면 방문한 것
            if(target > 'Z') return false;

            // 만약 방문을 한 노드이거나 색이 다른 노드라면 false를 반환
            if (target != curColor) {
                return false;
            }
            // 같은 색의 노드라면 다음 노드를 탐색한다.
            adj[i][j] += 32;
            DFS(i, j);
            return true;
        }
    }

    public static void initValues() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        if (N < 1 || N > 100) return;
        adj = new char[N][N];

        // 직사각형이 그려진 영역은 1로 표시한다.
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char[] temps = st.nextToken().toCharArray();
            for (int j = 0; j < N; j++) {
                char temp = temps[j];
                adj[i][j] = temp;
            }
        }
    }


    public static boolean getStartPoint() {
        for (int i = startI; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isNonRed) {
                    if (adj[i][j] >= 'a') {
                        curColor = adj[i][j];
                        startI = i;
                        startJ = j;
                        return true;
                    }

                } else {
                    if (adj[i][j] <= 'Z') {
                        curColor = adj[i][j];
                        startI = i;
                        startJ = j;
                        return true;
                    }
                }

            }
        }
        return false;
    }
}