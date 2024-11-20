def solution(my_str, n):
    answer = []
    
    cnt = len(my_str) // n
    
    for i in range(0,len(my_str), n):
        print(my_str[i:n])
        
    return answer


solution("abc1Addfggg4556b",6)