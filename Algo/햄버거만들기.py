from collections import deque

def solution(ingredient):
    answer = 0
    stack = deque()
    check_list = []
    
    for item in ingredient:
        if item == 1:
            for i,c in enumerate(range(3,1,-1)):
                if c == check_list[0]:
                    check_list.pop()
                else:
                    break
        else:
            stack.append(item)
            check_list.append(item)
        
    
    print(stack)
    
    return answer

solution([2, 1, 1, 2, 3, 1, 2, 3, 1])