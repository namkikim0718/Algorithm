import sys
input = sys.stdin.readline

prob = list(map(str, input().rstrip()))

prob.sort()

answer = [0 for _ in range(len(prob))]
length = len(prob)

if len(prob) % 2 == 1:
    index = 0
    prob_idx = 0
    while prob_idx < length:
        if (prob_idx < len(prob) - 1) and (prob[prob_idx] == prob[prob_idx+1]):
            answer[index] = prob[prob_idx]
            answer[length - index - 1] = prob[prob_idx+1]
            prob_idx += 1
            index += 1
        else:
            answer[length // 2] = prob[prob_idx]
        
        prob_idx += 1

else:
    index = 0
    prob_idx = 0
    while prob_idx < length - 1:
        if prob[prob_idx] == prob[prob_idx+1]:
            answer[index] = prob[prob_idx]
            answer[length - index -1] = prob[prob_idx+1]
            prob_idx += 1
            index += 1
        
        prob_idx += 1

if 0 in answer:
    print("I'm Sorry Hansoo")
else:
    print(''.join(answer))
    