first = input()
second = input()
cnt = 0

i = 0
while i < len(first)-len(second)+1:
    tmp = first[i:i+len(second)]

    if tmp.find(second) != -1:
        i = i + len(second)
        cnt += 1
    else:
        i += 1

    
print(cnt)