import sys
input = sys.stdin.readline

N = int(input())

plist = list(map(int, input().split()))
result = [-1 for i in range(N)]

for i in range(N):
    # result에서 -1의 개수
    cnt = 0
    # result에서 사람을 넣을 인덱스
    index = 0

    # -1의 개수가 plist[i]와 같아질때까지 인덱스가 올라감
    while cnt < plist[i]:
        if result[index] == -1:
            cnt += 1
        index += 1
    # 자신의 앞에 -1이 plist[i]와 같아졌는데 이미 다른 값이 들어가 있을 때,
    # 아무 값이 안들어간 -1이 나타날때까지 인덱스 증가
    while result[index] != -1:
        index += 1
    result[index] = i+1
    
for i in result:
    print(i, end=' ')