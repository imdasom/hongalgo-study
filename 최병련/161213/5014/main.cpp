//
// https://www.acmicpc.net/problem/5014
// 5014 스타트링크
//
// 도움받은사이트 : http://dyndy.tistory.com/174
//


#include    <stdio.h>
#include    <queue>
#pragma warning(disable : 4996)

static std::queue<int> q;
static int BUTTON[1111111];
static int VISIT[1111111];
static int F;   //건물 층 개수
static int S;   //강호가 현재 있는 층
static int G;   //스타트링크가 있는 층
static int U;   //위 U층으로 가는버튼
static int D;   //아래로 D층을 가는 버튼

void bfs()
{
    while (!q.empty())
    {
        int f = q.front();
        q.pop();
        if (f==G)
            return;
        if (f + U <= F && VISIT[f + U] == 0)
        {
            BUTTON[f + U] = BUTTON[f] + 1;
            q.push(f + U);
            VISIT[f + U] = 1;
        }
        if (f - D >= 1 && VISIT[f - D] == 0)
        {
            BUTTON[f - D] = BUTTON[f] + 1;
            q.push(f - D);
            VISIT[f - D] = 1;
        }
    }
}
int main()
{
    scanf("%d %d %d %d %d", &F, &S, &G, &U, &D);
    if (S == G)
    {
        printf("%d\n",0);
        return 0;
    }
    VISIT[S] = 1;
    BUTTON[S] = 0;
    q.push(S);
    bfs();
    if (VISIT[G] == 0)
        printf("use the stairs\n");
    else
        printf("%d\n", BUTTON[G]);
    
    return 0;
}
