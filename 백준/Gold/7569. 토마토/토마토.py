import sys
input = sys.stdin.readline
from collections import deque

M, N, H = map(int, input().split())

graph = []

for i in range(H):
    tmp_H = []
    for j in range(N):
        tmp_H.append(list(map(int, input().split())))
    graph.append(tmp_H)

q = deque()

dx = [0, 0, 1, -1, 0, 0]
dy = [1, -1, 0, 0, 0, 0]
dz = [0, 0, 0, 0, 1, -1]

def bfs():

    while q:
        z, x, y = q.popleft()
        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            nz = z + dz[i]
            if 0<=nx<N and 0<=ny<M and 0<=nz<H and graph[nz][nx][ny] == 0:
                graph[nz][nx][ny] = graph[z][x][y] + 1
                q.append((nz, nx, ny))

for k in range(H):
    for i in range(N):
        for j in range(M):
            if graph[k][i][j] == 1:
                q.append((k, i, j))

bfs()

day = 0
is_impossible = False

for k in range(H):
    for i in range(N):
        for j in range(M):
            if graph[k][i][j] == 0:
                is_impossible = True
            day = max(day, graph[k][i][j])

if is_impossible:
    print(-1)
else:
    print(day-1)