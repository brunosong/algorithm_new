def solution(n):
    answer = set()
    
    num = 2
    while n > 1:
        if n % num == 0:
            answer.add(num)
            n = n // num
            num = 2
        else:
            num += 1
        
    return answer


print(solution(420))