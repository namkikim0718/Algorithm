import sys
input = sys.stdin.readline
from collections import deque

N, M, R = map(int, input().split())
arr = []
for _ in range(N):
    arr.append(list(map(int, input().split())))

result = [[0 for _ in range(M)] for _ in range(N)]
q = deque()

rotate_cnt = min(N, M)//2

for i in range(rotate_cnt):
    q.clear()
    q.extend(arr[i][i:M-i])
    q.extend([row[M-i-1] for row in arr[i+1:N-i-1]])
    q.extend(arr[N-i-1][i:M-i][::-1])
    q.extend([row[i] for row in arr[i+1:N-i-1]][::-1])

    q.rotate(-R)

    for j in range(i, M-i):                 # 위쪽
        result[i][j] = q.popleft()
    for j in range(i+1, N-i-1):             # 오른쪽
        result[j][M-i-1] = q.popleft()
    for j in range(M-i-1, i-1, -1):           # 아래쪽
        result[N-i-1][j] = q.popleft()  
    for j in range(N-i-2, i, -1):           # 왼쪽
        result[j][i] = q.popleft()  

for i in result:
    for j in i:
        print(j, end=' ')
    print()