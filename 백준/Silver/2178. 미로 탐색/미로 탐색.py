from collections import deque
import sys
input = sys.stdin.readline


def bfs(x, y):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    queue = deque()
    queue.append((x, y))

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < M and graph[nx][ny] == 1:
                queue.append((nx, ny))
                graph[nx][ny] = graph[x][y] + 1
    return graph[N-1][M-1]
    

N, M = map(int, input().split())

graph = []
for i in range(N):
    graph.append(list(map(int, input().rstrip())))

print(bfs(0, 0))