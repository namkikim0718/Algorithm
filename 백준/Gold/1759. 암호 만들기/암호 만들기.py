import sys
input = sys.stdin.readline
from itertools import combinations

L, C = map(int, input().split())
alphabets = list(map(str, input().split()))
alphabets.sort()

codes = list(combinations(alphabets, L))

for code in codes:
    my_list = code
    vowel = 0
    vowel += my_list.count('a')
    vowel += my_list.count('e')
    vowel += my_list.count('i')
    vowel += my_list.count('o')
    vowel += my_list.count('u')
    if vowel != 0 and L - vowel > 1:
        for alpha in my_list:
            print(alpha, end='')
        print()