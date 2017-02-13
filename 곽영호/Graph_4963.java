import java.util.Scanner;

/**
 * Created by yhk on 17. 2. 13..
 * url:https://www.acmicpc.net/problem/4963
 */
public class Graph_4963 {
    static int w = 0;
    static int h = 0 ;
    static int[][] map = null;
    static int[][] visit = null;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean bTest = true;
        while(bTest) {
            String[] testInfo = scan.nextLine().split(" ");
            w = Integer.parseInt(testInfo[0]);
            h = Integer.parseInt(testInfo[1]);
            if(w == 0 && h == 0){
                break;
            }
            map = new int[w][h];
            visit = new int[w][h];

            for (int i = 0; i < h; i++) {
                String[] MapInfo = scan.nextLine().split(" ");
                for(int j = 0 ; j < w; j++){
                    map[j][i] = Integer.parseInt(MapInfo[j]);
                }
            }

            int cnt = 0;
            for (int x = 0; x < w; x++) {
                for (int y = 0; y < h; y++) {
                    if (map[x][y] == 1 && visit[x][y] == 0) {
                        if(dfs(new Pos(x,y)) > 0 ) cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
        scan.close();
    }

    static int dfs(Pos pos){
        int cnt = 1;

        if(pos.x >= 0 && pos.x < w && pos.y >= 0 && pos.y < h && map[pos.x][pos.y] == 1 && visit[pos.x][pos.y] == 0) {
            visit[pos.x][pos.y] = 1;
        }else{
            return 0;
        }

        //가로,세로
        cnt += dfs(new Pos(pos.x+1, pos.y));
        cnt += dfs(new Pos(pos.x-1, pos.y));
        cnt += dfs(new Pos(pos.x, pos.y+1));
        cnt += dfs(new Pos(pos.x, pos.y-1));

        //대각선
        cnt += dfs(new Pos(pos.x-1, pos.y-1));
        cnt += dfs(new Pos(pos.x+1, pos.y-1));
        cnt += dfs(new Pos(pos.x+1, pos.y+1));
        cnt += dfs(new Pos(pos.x-1, pos.y+1));


        return cnt;

    }

    static class Pos{
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
