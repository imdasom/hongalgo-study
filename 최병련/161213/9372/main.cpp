//
//  main.cpp
//  BFS
//
//  Created by ByeongRyeon Choi on 2016. 12. 12..
//  Copyright © 2016년 gandromeda. All rights reserved.
//
// https://www.acmicpc.net/problem/9372
// 상근이의 여행
//
// http://yukari-ko.blogspot.kr/2014/08/9372.html

#include <iostream>
using namespace std;

int t;  //테스트케이스 갯수
int n,m;    //n == 국가의수, m == 비행기 종류
int a,b;    // 연결되는 쌍 a, b
int main()
{
    for(scanf("%d",&t);t--;)
    {
        scanf("%d%d",&n,&m);
        for(int i=0;i<m;i++)
        {
            scanf("%d%d",&a,&b);
        }
        printf("%d\n",n-1);
    }
    return 0;
}