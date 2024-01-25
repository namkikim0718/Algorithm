import sys
input = sys.stdin.readline

num_list = []

N = int(input())
for _ in range(N):
    num_list.append(int(input()))

num_list.sort()
for i in num_list:
    print(i)    