S = input()
P = input()
cnt = 1
idx = 0


#find() -> 문자열이 존재하면 인덱스 반환, 없으면 -1 반환
#idx는 P내부에서의 start인덱스, i는 end인덱스-1
#S에 문자열 겹치는게 없으면 그 직전까지가 최대 길이.
for i in range(len(P)):
    if S.find(P[idx:i+1]) != -1: continue
    idx = i
    cnt += 1

print(cnt)
    