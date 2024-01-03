import sys
input = sys.stdin.readline

K = int(input())
num_list = []
for i in range(K):
    tmp = int(input())
    if tmp == 0:
        num_list.pop()
        continue
    num_list.append(tmp)

print(sum(num_list))
    