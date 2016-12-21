package bj05014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by imdasom on 2016-12-21.
 */
public class Main {
    static int F, S, G, U, D, visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());

        if (G == S){
            System.out.println("0");
            return;
        }

        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        visited = new int[F + 1];
        br.close();


        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        visited[S] = 1;

        while (!q.isEmpty()) {
            int curS = q.poll();
            if (curS == G) {
                break;
            }

            int caseUp = curS + U;
            if (caseUp <= F && visited[caseUp] == 0) {
                q.offer(caseUp);
                visited[caseUp] = visited[curS] + 1;
            }

            int caseDown = curS - D;
            if (caseDown > 0 && visited[caseDown] == 0) {
                q.offer(caseDown);
                visited[caseDown] = visited[curS] + 1;
            }
        }
        if(visited[G] == 0) System.out.println("use the stairs");
        else System.out.println(visited[G]-1);

    }
}
