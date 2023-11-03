import sys
input = sys.stdin.readline

N = int(input())
M = int(input())
graph = [[] for _ in range(N+1)]
for i in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
visited = [False] * (N+1)
result = [0]

def dfs(start):
    result[0] += 1
    visited[start] = True

    for i in graph[start]:
        if visited[i] == False:
            dfs(i)


dfs(1)
print(result[0]-1)