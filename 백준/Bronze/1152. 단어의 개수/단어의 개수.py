import sys
input = sys.stdin.readline

input_str = input().lstrip().rstrip()
cnt = 0

for i in input_str:
    if i == ' ':
        cnt += 1

if len(input_str) == 0:
    print(0)
else:
    print(cnt+1)
