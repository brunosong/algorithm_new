
from collections import deque

def solution(arr):
    answer = []
    i = 0
    stk = []
    
    while i < len(arr):
        if stk and stk[-1] == arr[i]:
            stk.pop()
        else:
            stk.append(arr[i])
            
        i += 1
    
    return stk or -1

solution([0, 1, 1, 1, 0])