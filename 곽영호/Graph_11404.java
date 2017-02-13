import java.util.Scanner;

/**
 * Created by yhk on 17. 2. 13..
 * url:https://www.acmicpc.net/problem/11404
 */
public class Graph_11404 {
    static int[][] line = null;
    static int[][] line_check = null;
    static int cityCnt = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        cityCnt = scan.nextInt();
        int lineCnt = scan.nextInt();
        line = new int[cityCnt + 1][cityCnt + 1];
        line_check = new int[cityCnt + 1][cityCnt + 1];
        scan.nextLine();
        for (int i = 0; i < lineCnt; i++) {
            String[] lineInfo = scan.nextLine().split(" ");
            int start = Integer.parseInt(lineInfo[0]);
            int end = Integer.parseInt(lineInfo[1]);
            int fee = Integer.parseInt(lineInfo[2]);
            if (line[start][end] == 0) {
                line[start][end] = fee;
            } else if (line[start][end] > fee) {
                line[start][end] = fee;
            }
        }
        scan.close();
        
        // map[i][j] = min(map[i][k] + map[k][j]) 라고 생각
	    // map[i][j]를 i에서 j까지 가는 최소경로라고 정의할때
	    // 모든 노드 포함된 맵이 반영되어야 최소경로를 알 수 있다.
	    // 즉, 노드를 하나씩 추가하여 모두 추가했을때, 최소경로를 알 수 있다.
        for (int k = 1; k <= cityCnt; k++) {
            for (int i = 1; i <= cityCnt; i++) {
                for (int j = 1; j <= cityCnt; j++) {
                    if (line[i][k] != 0 && line[k][j] != 0 && i != j) {
                        if (line[i][j] != 0) {
                            if (line[i][j] > line[i][k] + line[k][j]) {
                                line[i][j] = line[i][k] + line[k][j];
                            }
                        } else {
                            line[i][j] = line[i][k] + line[k][j];
                        }
                    }
                }
            }
        }

        for (int i = 1; i < line.length; i++) {
            for (int j = 1; j < line[i].length; j++) {
                System.out.print(line[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
