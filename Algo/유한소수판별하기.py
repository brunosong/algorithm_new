from math import gcd

def solution(a, b):
    
    # 분자와 분모의 최대공약수를 구합니다
    greatest_common_divisor = gcd(a, b)
    
    simplest_denominator = b // greatest_common_divisor
    
    answer = 2
    
    temp = set()
    
    cnt = 2
    while simplest_denominator > 1:
        if simplest_denominator % cnt == 0:
            temp.add(cnt)    
            simplest_denominator //= cnt
        else:
            cnt += 1
            
    if temp == {2} or temp == {5} or temp == {2, 5}:
        return 1
    
    return answer


solution(11,22)