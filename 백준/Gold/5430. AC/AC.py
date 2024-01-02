import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    p = list(map(str, input().rstrip()))
    n = int(input())
    if n == 0:
        input()
        if p.count('D') > 0:
            print('error')
        else:
            print('[]')
        continue
    num_list = list(map(int, input().strip('[]\n').split(',')))
    is_error = False
    
    cnt_reverse = 0

    for ac in p:
        if ac == 'R':
            cnt_reverse += 1
        elif ac == 'D':
            if len(num_list) == 0:
                is_error = True
                break
            else:
                if cnt_reverse % 2 == 1:
                    num_list.pop()
                else:
                    num_list.pop(0)
                
    if is_error:
        print('error')
    else:
        print('[', end='')
        if len(num_list) != 0:
            if cnt_reverse % 2 == 1:
                num_list.reverse()
            for i in range(len(num_list)-1):
                print(num_list[i], end=',')
            print(num_list[len(num_list)-1], end='')
        print(']')