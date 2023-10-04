import sys
input = sys.stdin.readline

def ispseudo(word, left, right):
    while left < right:
        if word[left] != word[right]:
            return False
        left += 1
        right -= 1
    return True

def ispanlindrome(word, left, right):
    while left < right:
        if word[left] != word[right]:
            check_left = ispseudo(word, left+1, right)
            check_right = ispseudo(word, left, right-1)

            if check_left or check_right:
                return 1
            else:
                return 2
        left += 1
        right -= 1
    return 0
            

n = int(input())
str_list = []
for i in range(n):
    tmp = input().rstrip('\n')
    str_list.append(tmp)

for i in range(n):
    left = 0
    right = len(str_list[i])-1
    print(ispanlindrome(str_list[i], left, right))