import sys
input = sys.stdin.readline
from collections import deque

def bfs(a, b):
    q = deque()
    q.append((a, b))
    graph[a][b] = 1

    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    global space_cnt

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < M and 0 <= ny < N:
                if graph[nx][ny] != 1:
                    q.append((nx, ny))
                    graph[nx][ny] = 1
                    space_cnt += 1


M, N, K = map(int, input().split())
graph = []
for i in range(M):
    tmp = []
    for j in range(N):
        tmp.append(0)
    graph.append(tmp)

wall = []
for _ in range(K):
    wall.append(list(map(int, input().split())))

for k in range(K):
    y1 = wall[k][0]
    x1 = wall[k][1]
    y2 = wall[k][2]
    x2 = wall[k][3]
    for i in range(x1, x2):
        for j in range(y1, y2):
            graph[i][j] = 1

space = []
cnt = 0
space_cnt = 1
for i in range(M):
    for j in range(N):
        if graph[i][j] == 0:
            space_cnt = 1
            cnt += 1
            bfs(i, j)
            space.append(space_cnt)

print(cnt)
space.sort()
for i in space:
    print(i, end = ' ')