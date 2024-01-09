import sys
input = sys.stdin.readline

input_num = int(input())
first = -1
second = -1

if input_num < 10:
    first = 0
    second = input_num
else:
    first = input_num // 10
    second = input_num - (first * 10)

cnt = 1

while True:
    now_sum = first + second
    first = second
    second = now_sum % 10
    if (first * 10 + second) == input_num:
        break
    cnt += 1
print(cnt)