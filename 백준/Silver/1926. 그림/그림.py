import sys
input = sys.stdin.readline
from collections import deque

def bfs(a, b):
    q = deque()
    q.append((a, b))
    graph[a][b] = 0

    global size

    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<n and 0<=ny<m and graph[nx][ny]==1:
                q.append((nx, ny))
                graph[nx][ny] = 0
                size += 1

n, m = map(int, input().split())
graph = []

for _ in range(n):
    graph.append(list(map(int, input().split())))


size_list = []


cnt = 0
for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            size = 1
            bfs(i, j)
            cnt += 1
            size_list.append(size)

print(cnt)
if not size_list:
    print(0)
else:
    print(max(size_list))