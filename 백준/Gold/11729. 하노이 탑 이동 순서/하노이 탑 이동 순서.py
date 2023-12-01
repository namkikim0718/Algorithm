import sys
input = sys.stdin.readline

def hanoi(n, start, end):
    global cnt
    cnt += 1
    if n == 1:
        result.append((start, end))
        return
    
    hanoi(n-1, start, 6-start-end)
    result.append((start, end))
    hanoi(n-1, 6-start-end, end)

N = int(input())
result = []
cnt = 0

hanoi(N, 1, 3)

print(cnt)
for i in range(cnt):
    a, b = result[i]
    print(a, b)