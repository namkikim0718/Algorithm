import sys
input = sys.stdin.readline

first  = input().rstrip()
num_list = []
for i in range(len(first)):
    num_list.append(int(first[i]))

cnt = 0

if num_list.count(0) == 0 or num_list.count(1) == 0:
    cnt = 0
elif num_list[0] == 0:
    for i in range(len(num_list)-1):
        if num_list[i] == 0 and num_list[i+1] == 1:
            cnt += 1
else:
    for i in range(len(num_list)-1):
        if num_list[i] == 1 and num_list[i+1] == 0:
            cnt += 1
print(cnt)
