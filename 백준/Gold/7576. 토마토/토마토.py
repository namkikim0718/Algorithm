import sys
input = sys.stdin.readline
from collections import deque

def bfs():

    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    global day

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<N and 0<=ny<M and graph[nx][ny] == 0:
                graph[nx][ny] = graph[x][y] + 1
                day = graph[nx][ny]
                q.append((nx, ny))

M, N = map(int, input().split())

graph = []

for _ in range(N):
    graph.append(list(map(int, input().split())))

day = 1
q = deque()

for i in range(N):
    for j in range(M):
        if graph[i][j] == 1:
           q.append((i, j)) 

bfs()

is_possible = True

for i in range(N):
    for j in range(M):
        if graph[i][j] == 0:
            is_possible = False
            break

if is_possible:
    print(day - 1)
else:
    print(-1)