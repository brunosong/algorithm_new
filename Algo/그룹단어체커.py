n = int(input())

answer = 0


def word_checker(words):
    check_set = set()
    prev_word = " "
    for w in words:
        if w in check_set:
            return False

        if prev_word != w:
            check_set.add(w)

        prev_word = w
    return True


for _ in range(n):
    word = input()
    if word_checker(word):
        answer += 1

print(answer)
