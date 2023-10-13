import sys
input = sys.stdin.readline
from collections import deque

n, l = map(int, input().split())
arr = list(map(int, input().split()))

result = deque()
for i in range(n):
    # 덱에 값이 있고, 덱의 가장 마지막 value가 arr[i]보다 크다면
    # 덱의 가장 마지막 값 pop.
    while result and (result[-1][1] > arr[i]):
        result.pop()
    
    # 덱에 arr[i]를 추가.
    result.append((i + 1, arr[i]))

    # 덱의 마지막 요소의 index와 첫번재 index의 차이가 l보다 크면
    # 덱의 가장 첫번째 값 pop.
    if result[-1][0] - result[0][0] >= l:
        result.popleft()
    
    # 덱의 가장 첫번째 요소의 value가 슬라이딩 윈도우 내의 최솟값.
    print(result[0][1], end = ' ')