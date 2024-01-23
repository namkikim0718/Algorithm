import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    test_input = list(map(str, input().rstrip()))
    linear_cnt = 0
    result = 0
    for i in range(len(test_input)):
        if test_input[i] == 'O':
            if i - 1 >= 0 and test_input[i-1] == 'O':
                linear_cnt += 1
            else:
                linear_cnt = 0
            result += 1+linear_cnt
    print(result)
