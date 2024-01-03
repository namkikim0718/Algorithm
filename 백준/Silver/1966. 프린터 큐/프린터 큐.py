import sys
input = sys.stdin.readline
from collections import deque

T = int(input())
ans = []

for i in range(T):
    N, M = map(int, input().split())
    docs = list(map(int, input().split()))
    cnt = 0

    q = deque(docs)
    while q:
        M -= 1
        max_value = max(q)
        front = q.popleft()
        if max_value == front:
            cnt += 1
            if M < 0:
                ans.append(cnt)
                break    
        else:
            q.append(front)
            if M < 0:
                M = len(q) - 1
    
for i in ans:
    print(i)