from collections import deque

def solution(ingredient):
    answer = 0
    stack = deque()

    for item in ingredient:
        if item == 1:
            check_cnt = 3
            temp = []
            while len(stack) > 0 and stack[-1] == check_cnt:
                temp.append(stack.pop())
                check_cnt -= 1

            if check_cnt == 0:
                answer += 1
            else:
                while temp:
                    stack.append(temp.pop())
                stack.append(item)
        else:
            stack.append(item)

    return answer

print(solution([2, 1, 1, 2, 3, 1, 2, 3, 1]))