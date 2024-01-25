import sys
input = sys.stdin.readline

num_list = []
remain_list = []

for _ in range(10):
    num_list.append(int(input()))

for i in num_list:
    remain = i % 42
    if remain not in remain_list:
        remain_list.append(remain)

print(len(remain_list))