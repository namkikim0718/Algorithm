import sys
input = sys.stdin.readline
import copy
from collections import deque

N, M = map(int, input().split())
graph = []

for _ in range(N):
    graph.append(list(map(int, input().split())))

result = 0

def bfs():
    q = deque()
    tmp_graph = copy.deepcopy(graph)
    global result

    for i in range(N):
        for j in range(M):
            if tmp_graph[i][j] == 2:
                q.append((i, j))
    

    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<N and 0<=ny<M and tmp_graph[nx][ny] == 0:
                tmp_graph[nx][ny] = 2
                q.append((nx, ny))

    cnt = 0
    for i in range(N):
        cnt += tmp_graph[i].count(0)
    result = max(result, cnt)

def makeWall(cnt):
    if cnt == 3:
        bfs()
        return
    
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 0:
                graph[i][j] = 1
                makeWall(cnt+1)
                graph[i][j] = 0

makeWall(0)
print(result)