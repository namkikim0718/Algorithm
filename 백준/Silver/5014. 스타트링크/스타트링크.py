import sys
input = sys.stdin.readline
from collections import deque

def bfs(start):
    q = deque()
    q.append(start)
    visited[start] = 1

    while q:
        loc = q.popleft()
        if loc == G:
            return visited[loc]
        nloc = loc + U
        if 1<=nloc<=F and visited[nloc]==0:
            visited[nloc] = visited[loc] + 1
            q.append(nloc)
        nloc = loc - D
        if 1<=nloc<=F and visited[nloc]==0:
            visited[nloc] = visited[loc] + 1
            q.append(nloc)
    return -1

F, S, G, U, D = map(int, input().split())
visited = [0 for _ in range(F + 1)]

least_move = bfs(S)
if least_move == -1:
    print('use the stairs')
else:
    print(least_move-1)