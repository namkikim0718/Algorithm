import sys
input = sys.stdin.readline

n = int(input())

minus_arr = []
plus_arr = []
one_arr = []
for i in range(n):
    tmp = int(input())
    if tmp == 1:
        one_arr.append(tmp)
    elif tmp > 0:
        plus_arr.append(tmp)
    else:
        minus_arr.append(tmp)

minus_arr.sort()
plus_arr.sort(reverse=True)

result = 0
if len(plus_arr) % 2 == 1:
    result += plus_arr[len(plus_arr)-1]
    for i in range(0, len(plus_arr)-1, 2):
        result += plus_arr[i] * plus_arr[i+1]
else:
    for i in range(0, len(plus_arr)-1, 2):
        result += plus_arr[i] * plus_arr[i+1]

if len(minus_arr) % 2 == 1:
    result += minus_arr[len(minus_arr)-1]
    for i in range(0, len(minus_arr)-1, 2):
        result += minus_arr[i] * minus_arr[i+1]
else:
    for i in range(0, len(minus_arr)-1, 2):
        result += minus_arr[i] * minus_arr[i+1]

if len(one_arr) > 0:
    result += len(one_arr)

print(result)