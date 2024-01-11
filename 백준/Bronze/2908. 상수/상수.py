import sys
input = sys.stdin.readline

A, B = map(str, input().split())

A = A[2] + A[1] + A[0]
B = B[2] + B[1] + B[0]

A = int(A)
B = int(B)

if A > B:
    print(A)
else:
    print(B)