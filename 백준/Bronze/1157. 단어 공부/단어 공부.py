import sys
input = sys.stdin.readline

input_str = input().upper().rstrip()

alpha = list(set(input_str))
count = []

for i in alpha:
    count.append(input_str.count(i))

max_cnt = max(count)
if count.count(max_cnt) > 1:
    print('?')
else:
    max_alpha = count.index(max_cnt)
    print(alpha[max_alpha])
    