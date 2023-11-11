import sys
input = sys.stdin.readline
from collections import deque

N, K = map(int, input().split())
graph = [0]* 100001
q = deque()
q.append(N)

def bfs():
    while q:
        x = q.popleft()
        if x == K:
            print(graph[x])
            break
        for nx in (x-1, x+1, x*2):
            if 0<= nx < 100001 and graph[nx] == 0:
                q.append(nx)
                graph[nx] = graph[x] + 1
                
bfs()