import sys
input = sys.stdin.readline
from collections import deque


N, M, V = map(int, input().split())

graph = [[] for i in range(N+1)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in graph:
    i.sort()

def dfs(start):
    visited[start] = True
    print(start, end=' ')

    for node in graph[start]:
        if not visited[node]:
            dfs(node)

def bfs(start):
    q = deque()
    q.append(start)
    visited[start] = True

    while q:
        node = q.popleft()
        print(node, end=' ')
        for i in graph[node]:
            if not visited[i]:
                q.append(i)
                visited[i] = True


visited = [False for i in range(N+1)]
dfs(V)

print()

visited = [False for i in range(N+1)]
bfs(V)