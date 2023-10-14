import sys
input = sys.stdin.readline

n = int(input())
arr = []
for i in range(n):
    s, e = map(int, input().split())
    arr.append([s, e])

# arr을 끝시간에 대해 정렬 후, 시작시간에 대해 정렬
arr.sort(key=lambda x:(x[1], x[0]))

end = 0
cnt = 0
for i in range(n):
    if arr[i][0] >= end:
        end = arr[i][1]
        cnt += 1

print(cnt)