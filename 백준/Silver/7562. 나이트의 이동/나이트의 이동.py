import sys
input = sys.stdin.readline
from collections import deque

def bfs(x1, y1, x2, y2, I):
    q = deque()
    q.append((x1, y1))

    dx = [-2, -2, -1, -1, 1, 1, 2, 2]
    dy = [-1, 1, -2, 2, -2, 2, -1, 1]

    while q:
        x, y = q.popleft()
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<I and 0<=ny<I and graph[nx][ny]==0:
                q.append((nx, ny))
                graph[nx][ny] = graph[x][y] + 1
                if nx == x2 and ny == y2:
                    return graph[nx][ny]

T = int(input())


for _ in range(T):
    I = int(input())
    graph = [[0 for i in range(I)] for j in range(I)]
    x1, y1 = map(int, input().split())
    x2, y2 = map(int, input().split())
    if x1 == x2 and y1 == y2:
        print(0)
    else:
        print(bfs(x1, y1, x2, y2, I))