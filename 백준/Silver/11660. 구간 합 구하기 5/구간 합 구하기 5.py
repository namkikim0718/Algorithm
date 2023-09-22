import sys

N, M = map(int, sys.stdin.readline().split())

#a = [list(map(int, input().split())) for i in range(N)]
a = []
for _ in range(N):
    a.append(list(map(int,sys.stdin.readline().split())))

sum_list = [[0 for i in range(N+1)] for j in range(N+1)]

for i in range(1, N+1):
    for j in range(1, N+1):
        sum_list[i][j] = sum_list[i][j-1] + sum_list[i-1][j] - sum_list[i-1][j-1] + a[i-1][j-1]


for i in range(M):
    x1, y1, x2, y2 = map(int,sys.stdin.readline().split())

    sum_result = sum_list[x2][y2] - sum_list[x1-1][y2] - sum_list[x2][y1-1] + sum_list[x1-1][y1-1]
    print(sum_result)    

    

