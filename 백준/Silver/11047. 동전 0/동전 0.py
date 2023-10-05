import sys
input = sys.stdin.readline

n, k = map(int, input().split())

m_list = []
for i in range(n):
    money = int(input())
    m_list.append(money)
m_list.sort(reverse=True)


cnt = 0
while k > 0:
    for i in range(n):
        if m_list[i] <= k:
            cnt += k//m_list[i]
            k -= m_list[i] * (k // m_list[i])
            
print(cnt)