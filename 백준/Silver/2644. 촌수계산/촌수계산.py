import sys
input = sys.stdin.readline


def dfs(node, num):
    num += 1
    visited[node] = True
    
    if node == B:
        result.append(num)
    
    for i in graph[node]:
        if not visited[i]:
            dfs(i, num)

N = int(input())
A, B = map(int, input().split())
M = int(input())

graph = [[] for _ in range(N+1)]
for i in range(M):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)


visited = [False] * (N+1)

result = []
dfs(A, 0)
if len(result) == 0:
    print(-1)
else:
    print(result[0] - 1)