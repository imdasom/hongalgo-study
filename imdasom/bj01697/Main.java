package bj01697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by pc on 2016-12-21.
 */
public class Main {

    static int N, K, visited[];

    public static void main(String[] args) throws IOException {
        initValues();

        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        visited[N] = 1;

        while(!q.isEmpty()){

            int NN = q.poll();
            if(NN == K) break;

            int minusN = NN-1;
            if(minusN >= 0 && visited[minusN]==0){
                visited[minusN] = visited[NN]+1;
                q.offer(minusN);
            }

            int plusN = NN+1;
            if(plusN <= 100000 && visited[NN+1]==0){
                visited[plusN] = visited[NN]+1;
                q.offer(plusN);
            }

            int sunganidongN = NN*2;
            if(sunganidongN <= 100000 && visited[NN*2]==0){
                visited[sunganidongN] = visited[NN]+1;
                q.offer(sunganidongN);
            }
        }

        System.out.println(visited[K]-1);
    }


    public static void initValues() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[100001];
        br.close();
    }
}
