import sys
input = sys.stdin.readline
from collections import deque

N = int(input())
graph = []
max_h = 0

for _ in range(N):
    graph.append(list(map(int, input().split())))
    max_h = max(max_h, max(graph[-1]))


dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs(a, b, k):
    q = deque()
    q.append((a, b))
    visited[a][b] = 1
    
    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N:
                if graph[nx][ny] > k and visited[nx][ny] == -1:
                    visited[nx][ny] = 1
                    q.append((nx, ny))


count = []

for k in range(max_h):
    visited = [[-1] * N for _ in range(N)]
    
    
    cnt = 0
    for i in range(N):
        for j in range(N):
            if graph[i][j] > k and visited[i][j] == -1:
                cnt += 1
                bfs(i, j, k)
    count.append(cnt)

print(max(count))
