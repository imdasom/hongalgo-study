package BreathFirshSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by yhk on 16. 12. 8..
 * url:https://www.acmicpc.net/problem/5014
 *
 * - 변수 의미 -
 * F: 총 층수
 * G: 스타트링크 층
 * S: 강호가 있는 층
 * U: 위로 U층
 * D: 아래로 D층
 *
 * - 조건 -
 * 엘레베이터 버튼 오직 2개
 * 엘리베이터를 이용해서 G층에 갈 수 없다면, "use the stairs"를 출력
 *
 * - 입력 -
 * 첫째 줄에 F, S, G, U, D가 주어진다. (1 ≤ S, G ≤ F ≤ 1000000, 0 ≤ U, D ≤ 1000000) 건물은 1층부터 시작하고, 가장 높은 층은 F층이다.
 *
 * - 출력 -
 * 첫째 줄에 강호가 S층에서 G층으로 가기 위해 눌러야 하는 버튼의 수의 최소값을 출력한다. 만약, 엘리베이터로 이동할 수 없을 때는 "use the stairs"를 출력한다.
 */
public class BFS_5014 {
    static Queue<Integer> q= new LinkedList<Integer>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arrInput = scan.nextLine().split(" ");
        int F = Integer.parseInt(arrInput[0]);
        int S = Integer.parseInt(arrInput[1]);
        int G = Integer.parseInt(arrInput[2]);
        int U = Integer.parseInt(arrInput[3]);
        int D = Integer.parseInt(arrInput[4]);

        int[] BUTTON = new int[F+1];
        int[] VISIT = new int[F+1];

        VISIT[S] = 1;
        BUTTON[S] = 0;
        q.add(S);
        int result = bfs(F, U, D, G, BUTTON, VISIT);
        if( result == -1){
            System.out.print("use the stairs");
        }else{
            System.out.print(result);
        }

    }

    static public int  bfs(int F, int U, int D, int G, int[] BUTTON, int[] VISIT){
        while(!q.isEmpty()){
            int f = q.poll();

            if(f + U <= F && VISIT[f + U] == 0 ){
                BUTTON[f+U] = BUTTON[f] + 1;
                q.add(f+U);
                VISIT[f+U] = 1;
            }

            if(f - D >= 1 && VISIT[f - D] == 0){
                BUTTON[f - D] = BUTTON[f] + 1;
                q.add(f - D);
                VISIT[f - D] = 1;
            }
        }

        if(VISIT[G] == 0){
            return -1;
        }else{
            return BUTTON[G];
        }
    }
}
