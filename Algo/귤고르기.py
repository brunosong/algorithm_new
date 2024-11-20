def solution(k, tangerine):
    answer = 0
    
    temp = {}
    
    for t in tangerine:
        temp[t] = temp.get(t,0) + 1
    
    sorted_items = sorted(temp.items(), key=lambda item:item[1], reverse=True)
    
    list = []
    
    for key, value in sorted_items:
        if answer < k:
            answer += value
            list.append(key)        
    
    return len(list)



solution(6,	[1, 3, 2, 5, 4, 5, 2, 3])