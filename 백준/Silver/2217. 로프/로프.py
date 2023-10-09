import sys
input = sys.stdin.readline

n = int(input())

arr = []
for i in range(n):
    tmp = int(input())
    arr.append(tmp)

arr.sort()

max_arr = []
for i in range(n):
    max_arr.append(arr[i] * (n-i))

print(max(max_arr))

