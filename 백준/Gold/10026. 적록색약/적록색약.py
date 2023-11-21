import sys
input = sys.stdin.readline
from collections import deque
import copy

def bfs(graph, a, b, color):
    q = deque()
    q.append((a, b))
    graph[a][b] = 'X'

    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<N and 0<=ny<N and graph[nx][ny]==color:
                graph[nx][ny] = 'X'
                q.append((nx, ny))

N = int(input())
graph = []
for _ in range(N):
    graph.append(list(input().rstrip()))

disabled_graph = copy.deepcopy(graph)

normal_cnt = 0
for i in range(N):
    for j in range(N):
        if graph[i][j] != 'X':
            bfs(graph, i, j, graph[i][j])
            normal_cnt += 1

for i in range(N):
    for j in range(N):
        if disabled_graph[i][j] == 'G':
            disabled_graph[i][j] = 'R'

disabled_cnt = 0
for i in range(N):
    for j in range(N):
        if disabled_graph[i][j] != 'X':
            bfs(disabled_graph, i, j, disabled_graph[i][j])
            disabled_cnt += 1
print(normal_cnt, end=' ')
print(disabled_cnt)