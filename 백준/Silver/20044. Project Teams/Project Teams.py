from itertools import combinations

n = int(input())
arr = list(map(int, input().split()))
sum_list = []

arr = sorted(arr)

for i in range(2*n):
    sum_list.append(arr[i] + arr[2*n-i-1])

print(min(sum_list))