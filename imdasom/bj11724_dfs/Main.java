package bj11724_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by imdasom on 2016-12-21.
 * <p>
 * 이문제는 인접행렬로 풀어도 된다.(정답자 중에 인접행렬로 푼 사람이 있다. 수행시간도 더 빠르다.)
 * 나는 연결리스트로 풀었다.
 */
public class Main {
    static int N, M;
    static ArrayList<Integer> adj[];

    static boolean[] visited;
    static int counter = 0;

    public static void main(String[] args) throws IOException {
        initValues();

        for (int i = 0; i < N; i++) {
            if (adj[i] == null) {
                counter++;
                continue;
            }
            if (!visited[i]) {
                DFS(i);
                counter++;
            }
        }

        System.out.println(counter);
    }

    public static void DFS(int i) {
        visited[i] = true;
        if (adj[i] == null) return;
        (adj[i]).stream().filter(Objects::nonNull).filter(j -> !visited[j]).forEachOrdered(Main::DFS);
    }

    public static void initValues() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken()) - 1;
            int V = Integer.parseInt(st.nextToken()) - 1;

            if (adj[U] == null) {
                (adj[U] = new ArrayList<>()).add(V);

            } else {
                adj[U].add(V);
            }

            if (adj[V] == null) {
                (adj[V] = new ArrayList<>()).add(U);

            } else {
                adj[V].add(U);
            }
        }

        br.close();
    }
}
