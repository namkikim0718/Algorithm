import sys
input = sys.stdin.readline
from collections import deque

def bfs(a, b):
    q = deque()
    q.append((a, b))
    graph[a][b] = -1

    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<N and 0<=ny<M and graph[nx][ny] == 1:
                q.append((nx, ny))
                graph[nx][ny] = -1

T = int(input())

for t_cnt in range(T):
    M, N, K = map(int, input().split())

    graph = [[0 for _ in range(M)] for _ in range(N)]

    for i in range(K):
        a, b = map(int, input().split())
        graph[b][a] = 1

    cnt = 0
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 1:
                bfs(i, j)
                cnt += 1
    print(cnt)