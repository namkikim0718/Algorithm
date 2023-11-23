import sys
input = sys.stdin.readline
from collections import deque
import copy

def bfs():
    q = deque()
    q.append((0, 0, 0))
    visited[0][0][0] = 1

    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    while q:
        x, y, is_break = q.popleft()
        if x == N-1 and y == M-1:
            return visited[is_break][x][y]

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<N and 0<=ny<M:
                if graph[nx][ny] == 1 and is_break == 0:
                    visited[1][nx][ny] = visited[0][x][y] + 1
                    q.append((nx, ny, 1))
                elif graph[nx][ny] == 0 and visited[is_break][nx][ny] == 0:
                    visited[is_break][nx][ny] = visited[is_break][x][y] + 1
                    q.append((nx, ny, is_break))

    return -1

N, M = map(int, input().split())

graph = []

for _ in range(N):
    graph.append(list(map(int, input().rstrip())))

visited = [[[0 for _ in range(M)] for _ in range(N)] for _ in range(2)]


print(bfs())
