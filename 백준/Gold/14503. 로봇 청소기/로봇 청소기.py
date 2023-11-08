import sys
input = sys.stdin.readline
from collections import deque

N, M = map(int, input().split())

x, y , direction = map(int, input().split())

graph = []
for j in range(N):
    graph.append(list(map(int, input().split())))

count = 0

def dfs(x, y, direction):
    global count
    
    while True:
        # 청소 X면 count 1증가 후 -1로 변경
        if graph[x][y] == 0:
            count += 1
            graph[x][y] = -1
        
        # x, y가 벽 안쪽이면서 4칸중 빈칸이 있는 경우
        if (0 < y < M-1 and graph[x][y+1] == 0) or (0 < y < M-1 and graph[x][y-1] == 0) or (0 < x < N-1 and graph[x+1][y] == 0) or (0 < x < N-1 and graph[x-1][y] == 0):
            for i in range(4):
                # 방향에 따라 그 위치가 빈칸인지 아닌지 판별
                # 빈칸이면 방향과 청소기의 위치 바꿔주고 for문 종료
                if direction == 0:
                    if graph[x][y-1] == 0:
                        direction = 3
                        y -= 1
                        break
                    direction = 3
                elif direction == 1:
                    if graph[x-1][y] == 0:
                        direction = 0
                        x -= 1
                        break
                    direction = 0
                elif direction == 2:
                    if graph[x][y+1] == 0:
                        direction = 1
                        y += 1
                        break
                    direction = 1
                elif direction == 3:
                    if graph[x+1][y] == 0:
                        direction = 2
                        x += 1
                        break
                    direction = 2
        # 4칸 중 빈칸이 없는 경우
        # 방향에 따라 후진 했을때 뒤쪽이 벽이면 return
        # 벽이 아니라면 청소기 위치 이동
        else:
            if direction == 0:
                if graph[x+1][y] == 1:
                    return
                else:
                    x += 1
            elif direction == 1:
                if graph[x][y-1] == 1:
                    return
                else:
                    y -= 1
            elif direction == 2:
                if graph[x-1][y] == 1:
                    return
                else:
                    x -= 1
            elif direction == 3:
                if graph[x][y+1] == 1:
                    return
                else:
                    y += 1
            

dfs(x, y, direction)
print(count)