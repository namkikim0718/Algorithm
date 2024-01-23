import sys
input = sys.stdin.readline

N = int(input())

cnt = 1
syom = 666

while cnt < N:
    syom += 1
    str_syom = str(syom)
    for i in range(len(str_syom)-2):
        if str_syom[i] == '6' and str_syom[i+1] == '6' and str_syom[i+2] == '6':
            cnt += 1
            break

print(syom)    