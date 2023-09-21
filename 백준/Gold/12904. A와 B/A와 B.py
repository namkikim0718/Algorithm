word1 = input()
word2 = input()

isPossible = 0

while len(word1) < len(word2):
    if word2[len(word2)-1] == "A":
        word2 = word2[:len(word2)-1]
    elif word2[len(word2)-1] == "B":
        word2 = word2[:len(word2)-1]
        word2 = word2[::-1]
    
if word1 == word2:
    print(1)
else:
    print(0)