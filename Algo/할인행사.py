def solution(want, number, discount):
    answer = 0
    
    want_product = {}
    
    for idx,product in enumerate(want):
        want_product[product] = number[idx]
        
    sliding_window = {}
    lt, rt = 0, 10
    
    for product in discount[lt:rt]:
        sliding_window[product] = sliding_window.get(product, 0) + 1
        
    if sliding_window == want_product:
        return answer + 1

    for idx in range(rt, len(discount)):
        cnt = sliding_window.get(discount[lt]) - 1
        if cnt == 0:
            del sliding_window[discount[lt]]
        else:
            sliding_window[discount[lt]] = cnt
        
        sliding_window[discount[rt]] = sliding_window.get(discount[rt],0) + 1
        
        lt += 1
        rt += 1
        
        if sliding_window == want_product:
            answer += 1

    return answer


print(solution(["banana", "apple", "rice", "pork", "pot"],
               [3, 2, 2, 2, 1],
               ["chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"]))